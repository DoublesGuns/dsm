package deepp.top.mall.service;

import deepp.top.login.common.ServerResponse;
import deepp.top.mall.vo.CartVo;

public interface ICartService {
    ServerResponse<CartVo> add(Integer userId, Integer productId, Integer count);
    ServerResponse<CartVo> update(Integer userId, Integer productId, Integer count);
    ServerResponse<CartVo> deleteProduct(Integer userId, String productIds);
    ServerResponse<CartVo> list(Integer userId);
    ServerResponse<CartVo> selectOrUnSelectAll(Integer userId, Integer productId, Integer checked);
    ServerResponse<Integer> getCartProductCount(Integer userId);
}
