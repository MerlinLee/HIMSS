package cn.edu.jlu.limf.controller;

/**
 * Created by merlin on 17-5-4.
 */

import cn.edu.jlu.limf.model.THealthRecordEntity;
import cn.edu.jlu.limf.model.TUserRoleEntity;
import cn.edu.jlu.limf.model.UserLoginInfoBean;
import cn.edu.jlu.limf.model.UsersEntity;
import cn.edu.jlu.limf.repository.THealthRecordRepository;
import cn.edu.jlu.limf.repository.UserRepository;
import cn.edu.jlu.limf.repository.UserRoleRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 *@作者：李铭峰-吉林大学-软件学院-13级02班
 *@Date 17-5-4 下午5:14
 */
@Controller
@RequestMapping(value = "/himsc")
public class AndroidHIMSController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserRoleRepository userRoleRepository;
    @Autowired
    THealthRecordRepository tHealthRecordRepository;
    @RequestMapping(value = "/loginCheckTest",method = POST,produces = "application/json;charset=utf-8")
    public @ResponseBody
    String  login_op(@RequestBody String json){
        return json;
    }
    @RequestMapping(value = "/test",method = GET,produces = "application/json;charset=utf-8")
    public @ResponseBody String test(){
        return "你好,我是李铭峰,来自吉林大学";
    }
    //@方法功能:查询mysql数据库中的用户信息,验证用户密码是否正确
    //@返回值:
    //          1.用户存在 1.1密码正确 1.2密码不正确
    //          2.用户不存在 直接返回错误
    @RequestMapping(value = "/loginCheckHIMSC",method = POST,produces = "application/json;charset=utf-8")
    public @ResponseBody String login_himsc_check(@RequestBody String json_login_info){
        Gson gson_info = new Gson();
        UserLoginInfoBean userLoginInfoBean = gson_info.fromJson(json_login_info,UserLoginInfoBean.class);
        try{
            UsersEntity userEntity_temp=userRepository.findByUserAccountId(userLoginInfoBean.getUserName());
            if (userEntity_temp.getUserAccountId().equals(userLoginInfoBean.getUserName())){
                if (userLoginInfoBean.getUserPsw().equals(userEntity_temp.getPassword())){
                    return "SUCCESS";
                }else {
                    return "ERORR";
                }
            }else {
                return "ERORR";
            }
        }catch(Exception e){
            return "ERORR";
        }
    }

    //接收来自客户端的注册信息并插入数据库中,分配NORMAL权限
    @RequestMapping(value = "/register_from_himsc",method = POST,produces = "application/json;charset=utf-8")
    public @ResponseBody String register_himsc(@RequestBody String json_register){
        Gson gson_info_register = new Gson();
        UsersEntity userRegisterInfoBean = gson_info_register.fromJson(json_register,UsersEntity.class);
        try {
            userRepository.saveAndFlush(userRegisterInfoBean);
            TUserRoleEntity userRoleEntity_insert = new TUserRoleEntity();
            userRoleEntity_insert.setRoleCode("NORMAL");
            userRoleEntity_insert.setUserAccountId(userRegisterInfoBean.getUserAccountId());
            userRoleRepository.saveAndFlush(userRoleEntity_insert);
            return "SUCCESS";
        }catch (Exception e){
            e.printStackTrace();
            return "FALSE";
        }
//        return json_register;
    }

    @RequestMapping(value = "/ReceiveUserRecord",method = POST,produces = "application/json;charset=utf-8")
    public @ResponseBody String ReceiveUtil(@RequestBody String json_info){
        Gson json_info_to_bean=new Gson();
        THealthRecordEntity tHealthRecordEntity = json_info_to_bean.fromJson(json_info,THealthRecordEntity.class);
        try {
            tHealthRecordRepository.saveAndFlush(tHealthRecordEntity);
            return "SUCCESS";
        }catch (Exception e){
            e.printStackTrace();
            return "FALSE";
        }

//        return json_info_to_bean.toJson(tHealthRecordEntity);
//        return json_info;
    }

    //接收android端上传的List对象
    @RequestMapping(value = "/uploadData",method = POST)
    public @ResponseBody String uploadData(@RequestBody String json_list){
        List<THealthRecordEntity> tHealthRecordEntities=new Gson().fromJson(json_list,new TypeToken<List<THealthRecordEntity>>(){}.getType());
        int size = tHealthRecordEntities.size();
        try {
            for (int i=0;i<size;i++) {
                tHealthRecordRepository.saveAndFlush(tHealthRecordEntities.get(i));
            }
            return "SUCCESS";
        }catch (Exception e){
            e.printStackTrace();
            return "FALSE";
        }
    }
}
