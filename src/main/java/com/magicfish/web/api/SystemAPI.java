package com.magicfish.web.api;

import com.alibaba.fastjson.JSONObject;
import com.magicfish.weroll.annotation.API;
import com.magicfish.weroll.annotation.Method;
import com.magicfish.weroll.annotation.Param;
import com.magicfish.weroll.exception.ServiceException;
import com.magicfish.weroll.net.APIAction;

import java.util.Date;

@API(name = "system")
public class SystemAPI {

    @Method(name = "ping",
            params = {
                    @Param(name = "name", type = "string"),
                    @Param(name = "gender", type = "int", defaultValue = "1")
            })
    public Object ping(String name, int gender, APIAction request) throws ServiceException {
        JSONObject result = new JSONObject();
        result.put("ip", request.getRemoteClientIP());
        result.put("time", new Date().toString());
        result.put("name", name);
        result.put("gender", gender);
        return result;
    }

}
