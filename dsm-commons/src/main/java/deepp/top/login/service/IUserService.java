package deepp.top.login.service;

import deepp.top.login.common.ServerResponse;
import deepp.top.login.pojo.User;

public interface IUserService {
    ServerResponse<User> login(String username, String password);
    ServerResponse<String> register(User user);
    ServerResponse<String> checkValid(String str, String type);
    ServerResponse selectQuestion(String username);
    ServerResponse<String> checkAnswer(String username, String question, String answer);
    ServerResponse<String> forgetRestPassword(String username, String passwordNew, String forgerToken);
    ServerResponse<String> restPassword(String passwordOld, String passwordNew, User user);
    ServerResponse<User> updateInformation(User user);
    ServerResponse<User> getInformation(Integer userId);
    public ServerResponse checkAdminRole(User user);
}
