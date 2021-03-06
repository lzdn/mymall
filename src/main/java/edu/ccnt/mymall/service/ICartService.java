package edu.ccnt.mymall.service;

import edu.ccnt.mymall.common.ServerResponse;
import edu.ccnt.mymall.vo.CartVo;

/**
 * Created by LXY on 2017/9/24.
 */
public interface ICartService {

    ServerResponse addCartProduct(Integer userId, Integer productId, Integer count);

    ServerResponse<CartVo> updateCartProduct(Integer userId, Integer productId, Integer count);

    ServerResponse<CartVo> deleteCartProducts(Integer userId,String products);

    ServerResponse<CartVo> selectOrUnSelect(Integer userId,Integer check,Integer productId);

    ServerResponse<CartVo> list (Integer userId);
}
