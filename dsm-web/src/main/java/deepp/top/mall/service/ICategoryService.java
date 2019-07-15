package deepp.top.mall.service;

import deepp.top.login.common.ServerResponse;
import deepp.top.mall.pojo.Category;

import java.util.List;

public interface ICategoryService {
    /**
     * 添加商品类型
     * @param categoryName
     * @param parentId
     * @return
     */
    ServerResponse addCategory(String categoryName, Integer parentId);

    /**
     * 更新商品类型名称
     * @param categoryId
     * @param categoryName
     * @return
     */
    public ServerResponse updateCategoryName(Integer categoryId, String categoryName);
    ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId);
    ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId);
}
