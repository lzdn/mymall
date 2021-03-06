package edu.ccnt.mymall.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import edu.ccnt.mymall.common.Const;
import edu.ccnt.mymall.common.ResponseCode;
import edu.ccnt.mymall.common.ServerResponse;
import edu.ccnt.mymall.dao.CategoryMapper;
import edu.ccnt.mymall.dao.ProductMapper;
import edu.ccnt.mymall.model.Category;
import edu.ccnt.mymall.model.Product;
import edu.ccnt.mymall.service.ICategoryService;
import edu.ccnt.mymall.service.IProductService;
import edu.ccnt.mymall.util.DateTimeUtil;
import edu.ccnt.mymall.util.PropertiesUtil;
import edu.ccnt.mymall.vo.ProductDetailVo;
import edu.ccnt.mymall.vo.ProductListVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service("iProductService")
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ICategoryService iCategoryService;

    @Override
    public ServerResponse productSaveOrInsert(Product product){
        log.info("更新或添加商品信息："+product);
        if(product != null){
            if(StringUtils.isNotBlank(product.getSubImages())){
                String[] images = product.getSubImages().split(",");
                if(images.length>0){
                    product.setMainImage(images[0]);
                }
            }
            if(product.getId()==null){      //添加商品
                int resultCount = productMapper.insert(product);
                if(resultCount>0){
                    return ServerResponse.createBySuccess("添加商品成功");
                }
                return ServerResponse.createByErrorMessage("添加商品失败");
            }else{  //更新商品
                int resultCount = productMapper.updateByPrimaryKeySelective(product);
                if(resultCount>0){
                    return ServerResponse.createBySuccess("更新商品成功");
                }
                return ServerResponse.createByErrorMessage("更新商品失败");
            }
        }
        return ServerResponse.createByErrorMessage("新增或更新商品参数不正确");
    }

    @Override
    public ServerResponse<String> updateProductStatus(Integer productId,Integer status){
        log.info("更新商品状态");
        if(productId == null || status == null){
            return ServerResponse.createByErrorMessage("更新商品状态参数错误");
        }
        Product product = new Product();
        product.setId(productId);
        product.setStatus(status);
        int resultCount = productMapper.updateByPrimaryKeySelective(product);
        if(resultCount>0){
            return ServerResponse.createBySuccessMessage("更新商品状态成功");
        }
        return ServerResponse.createByErrorMessage("更新商品状态失败");
    }

    @Override
    public ServerResponse<ProductDetailVo> getDetail(Integer productId){
        log.info("获取商品详细信息");
        if(productId==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGLE_ARGUMENT.getCode(),ResponseCode.ILLEGLE_ARGUMENT.getDesc());
        }
        Product product = productMapper.selectByPrimaryKey(productId);
        if(product == null){
            return ServerResponse.createByErrorMessage("商品不存在或已下架");
        }
        return ServerResponse.createBySuccess(assembleProductDetailVo(product));
    }

    private ProductDetailVo assembleProductDetailVo(Product product){
        ProductDetailVo productDetailVo = new ProductDetailVo();
        productDetailVo.setId(product.getId());
        productDetailVo.setStatus(product.getStatus());
        productDetailVo.setMainImage(product.getSubImages());
        productDetailVo.setCategoryId(product.getCategoryId());
        productDetailVo.setName(product.getName());
        productDetailVo.setSubImages(product.getSubImages());
        productDetailVo.setPrice(product.getPrice());
        productDetailVo.setStock(product.getStock());
        productDetailVo.setCreateTime(DateTimeUtil.dateToStr(product.getCreateTime()));
        productDetailVo.setUpdateTime(DateTimeUtil.dateToStr(product.getUpdateTime()));
        productDetailVo.setSubtitle(product.getSubtitle());
        productDetailVo.setDetail(product.getDetail());

        productDetailVo.setImageHost(PropertiesUtil.getProperty("ftp.server.http.prefix","http://img.happymmall.com/"));

        Category category = categoryMapper.selectByPrimaryKey(product.getCategoryId());
        if(category.getParentId() == null){
            productDetailVo.setParentCategoryId(0);
        }else{
            productDetailVo.setParentCategoryId(category.getParentId());
        }
        return productDetailVo;
    }

    @Override
    public ServerResponse<PageInfo> manageGetProductList(int pageNum, int pageSize){
        log.info("获取商品信息列表");
        //1、start pageHelper
        PageHelper.startPage(pageNum,pageSize);
        //2、填充查询逻辑
        List<Product> productList = productMapper.selectProductList();
        List<ProductListVo> productListVoList = Lists.newArrayList();
        for(Product product : productList){
            productListVoList.add(assembleProductListVo(product));
        }
        //3、pageHelper收尾
        PageInfo pageInfo = new PageInfo(productList);
        pageInfo.setList(productListVoList);
        return ServerResponse.createBySuccess(pageInfo);
    }

    public ProductListVo assembleProductListVo(Product product){
        ProductListVo productListVo = new ProductListVo();
        productListVo.setCategoryId(product.getCategoryId());
        productListVo.setId(product.getId());
        productListVo.setMainImage(product.getMainImage());
        productListVo.setName(product.getName());
        productListVo.setPrice(product.getPrice());
        productListVo.setSubtitle(product.getSubtitle());
        productListVo.setStatus(product.getStatus());
        productListVo.setImageHost(PropertiesUtil.getProperty("ftp.server.http.prefix","http://img.happymmall.com/"));

        return productListVo;
    }

    @Override
    public ServerResponse<PageInfo> searchProductList(String productName,Integer productId,int pageNum, int pageSize){
        log.info("搜索商品");
        //1、start pageHelper
        PageHelper.startPage(pageNum,pageSize);

        //2、搜索逻辑
        if(StringUtils.isNotBlank(productName)){
            productName = new StringBuilder().append("%").append(productName).append("%").toString();
        }
        List<Product> productList = productMapper.searchProductLsit(productName,productId);
        List<ProductListVo> productListVoList = Lists.newArrayList();
        for(Product product : productList){
            productListVoList.add(assembleProductListVo(product));
        }
        //3、pageHelper收尾
        PageInfo pageInfo = new PageInfo(productList);
        pageInfo.setList(productListVoList);
        return ServerResponse.createBySuccess(pageInfo);
    }

    public ServerResponse<PageInfo> searchProducts(String keyword, Integer categoryId, int pageNum, int pageSize, String orderBy){
        if(StringUtils.isBlank(keyword)&&categoryId==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGLE_ARGUMENT.getCode(),ResponseCode.ILLEGLE_ARGUMENT.getDesc());
        }
        List<Integer> categoryList = new ArrayList<Integer>();      //该类别及其子类别

        if(categoryId != null){
            Category category = categoryMapper.selectByPrimaryKey(categoryId);
            if(category==null&&StringUtils.isBlank(keyword)){       //没有该分类,并且还没有关键字,这个时候返回一个空的结果集,不报错
                PageHelper.startPage(pageNum,pageSize);
                List<ProductListVo> productListVoList = Lists.newArrayList();
                PageInfo pageInfo = new PageInfo(productListVoList);
                return ServerResponse.createBySuccess(pageInfo);
            }
            categoryList = iCategoryService.searchChildCategory(category.getId()).getData();
        }

        if(StringUtils.isNotBlank(keyword)){
            keyword = new StringBuilder().append("%").append(keyword).append("%").toString();
        }
        PageHelper.startPage(pageNum,pageSize);     //开始
        //排序处理
        if(StringUtils.isNotBlank(orderBy)){
            if(Const.ProductListOrderBy.PRICE_ASC_DESC.contains(orderBy)){
                String[] orderByArray = orderBy.split("_");
                orderBy = orderByArray[0]+" "+orderByArray[1];
            }
        }else
            orderBy = null;
        List<Product> list = productMapper.searchProducts(keyword,categoryList,orderBy);

        List<ProductListVo> productListVoList = Lists.newArrayList();
        for(Product product : list){
            ProductListVo productListVo = assembleProductListVo(product);
            productListVoList.add(productListVo);
        }
        PageInfo pageInfo = new PageInfo(list);
        pageInfo.setList(productListVoList);
        return ServerResponse.createBySuccess(pageInfo);
    }
}
