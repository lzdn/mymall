package edu.ccnt.mymall.service;

import edu.ccnt.mymall.common.ServerResponse;
import edu.ccnt.mymall.model.Product;
import edu.ccnt.mymall.vo.ProductDetailVo;

public interface IProductService {
    ServerResponse productSaveOrInsert(Product product);

    ServerResponse<String> updateProductStatus(Integer productId,Integer status);

    ServerResponse<ProductDetailVo> getDetail(Integer productId);
}