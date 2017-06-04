package cn.edu.jlu.limf.controller;

/**
 * Created by merlin Lee on 17-5-2.
 */

import cn.edu.jlu.limf.model.TUserRoleEntity;
import cn.edu.jlu.limf.model.UserLoginInfoBean;
import cn.edu.jlu.limf.model.UsersEntity;
import cn.edu.jlu.limf.repository.RoleRepository;
import cn.edu.jlu.limf.repository.UserRepository;
import cn.edu.jlu.limf.repository.UserRoleRepository;
import com.google.gson.Gson;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sun.xml.internal.ws.api.model.wsdl.WSDLBoundOperation.ANONYMOUS.required;

/**
 *@作者：李铭峰-吉林大学-软件学院-13级02班
 *@Date 17-5-2 下午9:02
 */
/**
 *@作者：李铭峰-吉林大学-软件学院-13级02班
 *@Date 17-5-14 下午4:38
 */
@Controller
@SessionAttributes("userAccounId")
public class MainController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private  HttpServletRequest request;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRoleRepository userRoleRepository;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/admin/users", method = RequestMethod.GET)
    public String getUsers(ModelMap modelMap) {
        // 查询user表中所有记录
        List<UsersEntity> userList = userRepository.findAll();
//        List<TRoleEntity> roleList = roleRepository.findAll();
//        List<TRoleEntity>roleList = roleRepository.findByRoleCode();
        // 将所有记录传递给要返回的jsp页面，放在userList当中
        modelMap.addAttribute("userList", userList);
//        String roleName = roleRepository.findByRoleCode(userList.get(1).getUserAccountId()).getRoleName();
//        modelMap.addAttribute(roleName,roleName);
// modelMap.addAttribute("roleList",roleList);
        // 返回pages目录下的admin/users.jsp页面
        return "admin/users";
    }

    // 删除用户
    @RequestMapping(value = "/admin/users/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") Integer userId) {

        // 删除id为userId的用户
        userRepository.delete(userId);
        // 立即刷新
        userRepository.flush();
        return "redirect:/admin/users";
    }

    //测试easyUI
    @RequestMapping(value = "/userviews/easyUITest", method = RequestMethod.GET)
    public String easyUI(){
        return "/userviews/easyUITest";
    }

    //测试easyUI登录测试界面
    @RequestMapping(value = "/userviews/loginTest", method = RequestMethod.GET)
    public String easyUI_login(){
        return "/userviews/loginTest";
    }

    //测试easyUI登录功能
    //

    @RequestMapping(value = "/admin/login_check",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody String login_check(@RequestBody String login_json, ModelMap modelMap) {
        Gson gson_info_web = new Gson();
//        ModelAndView mv;
        Map<String,String> map = new HashMap<>();
        try {
            UserLoginInfoBean userLoginInfoBean = gson_info_web.fromJson(login_json, UserLoginInfoBean.class);
            UsersEntity userEntity_temp = userRepository.findByUserAccountId(userLoginInfoBean.getUserName());
            if (userEntity_temp.getUserAccountId().equals(userLoginInfoBean.getUserName())) {
                if (userLoginInfoBean.getUserPsw().equals(userEntity_temp.getPassword())) {
                    TUserRoleEntity tUserRoleEntity = userRoleRepository.findByUserAccountId(userLoginInfoBean.getUserName());
                    modelMap.addAttribute("userAccountId",userLoginInfoBean.getUserName());
//                    mv=new ModelAndView("/userviews/sessionTest");
                    HttpSession session = request.getSession();
                    session.setAttribute("userAccountId", userLoginInfoBean.getUserName());
                    session.setAttribute("userRole",tUserRoleEntity.getRoleCode());
                    map.put("status","SUCCESS");
                    modelMap.addAttribute("userAccountId",userLoginInfoBean.getUserName());
                    return new Gson().toJson(map).toString();
//                        return mv;
                } else {
//                    mv=new ModelAndView("/admin/login_check");
                    map.put("status","ERROR");
                    return new Gson().toJson(map).toString();
//                    return mv;
                }
            } else {
                map.put("status","ERROR");
                return new Gson().toJson(map).toString();
//                mv = new ModelAndView("/admin/login_check");
//                return mv;
            }
        } catch (Exception e) {
//            mv = new ModelAndView("/admin/login_check");
            map.put("status",e.toString());
            return new Gson().toJson(map).toString();
//            return mv;
        }
    }
    //测试JQuery Table的前后端交互过程
    @RequestMapping(value = "/userviews/dataTransfer", method = RequestMethod.POST)
    public @ResponseBody String return_data(HttpServletRequest req,
                                            @RequestParam(required = false) String callback,
                                            @RequestParam(required = false) String searchType,
                                            @RequestParam(required = false) String draw,
                                            @RequestParam(required = false) Integer start,
                                            @RequestParam(required = false) Integer length){
        Map<String,Object> maps = new HashMap<>();
        List<UsersEntity> userList = userRepository.findAll();
        int totalCount = (int)userRepository.count();
        maps.put("draw", draw);
        maps.put("recordsTotal", totalCount);
        maps.put("recordsFiltered", totalCount);
        maps.put("data", userList);
        return new Gson().toJson(maps).toString();
    }

    //测试JQuery Ajax的前后端交互
    @RequestMapping(value = "/userviews/ajaxtest",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public @ResponseBody String ajaxTest(){
        Map<String,String> map = new HashMap<>();
        map.put("status","你好,我是李铭峰!");
        map.put("id","1994");
        return new Gson().toJson(map).toString();
    }

    //测试Session在服务端是否保存了相关信息，userAccountId
    @RequestMapping(value = "/userviews/session",method = RequestMethod.GET)
    public @ResponseBody String session_return(@ModelAttribute("userAccountId")String session){
        HttpSession session_o = request.getSession(false);
        Map<String,String> map = new HashMap<>();
        if(session_o==null){
            //没有登录成功，跳转到登录页面
            map.put("session:","session is null");
            return new Gson().toJson(map).toString();
        }else {
            map.put("session:",(String)session_o.getAttribute("userAccountId"));
            map.put("role:",(String)session_o.getAttribute("userRole"));
            return new Gson().toJson(map).toString();
        }
    }
    @RequestMapping(value = "/userviews/sessionTest",method = RequestMethod.GET)
    public String sessionTest(){
        return "/userviews/sessionTest";
    }

    @RequestMapping(value = "/isAdmin",method = RequestMethod.GET)
    public String isAdmin(){
        HttpSession session_o = request.getSession(false);
        String userRole=session_o.getAttribute("userRole").toString();
        if(userRole.equals("ROOT")){
            return "/userviews/goTOadmin";
        }else {
            return "/userviews/sessionTest";
        }
    }

    @RequestMapping(value = "/userviews/goTOadmin",method = RequestMethod.GET)
    public String goTOadmin(){return "/userviews/goTOadmin";}
}
