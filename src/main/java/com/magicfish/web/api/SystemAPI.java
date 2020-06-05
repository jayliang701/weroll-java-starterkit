package com.magicfish.web.api;

import com.alibaba.fastjson.JSONObject;
import com.magicfish.web.api.serializable.LocationParam;
import com.magicfish.weroll.annotation.API;
import com.magicfish.weroll.annotation.Method;
import com.magicfish.weroll.annotation.Param;
import com.magicfish.weroll.exception.ServiceException;
import com.magicfish.weroll.net.APIAction;

@API(name = "system")
public class SystemAPI {

    @Method(needLogin = false)
    public Object echo(@Param(defaultValue = "guest", required = false) String name,
                       Integer age,
                       @Param(defaultValue = "true", required = false) boolean isStudent,
                       @Param(defaultValue = "{ \"city\":\"Shanghai\", \"country\":\"China\" }") LocationParam location,
                       @Param(defaultValue = "[]", required = false) String[] tags,
                       APIAction action) throws ServiceException {
        JSONObject result = new JSONObject();
        result.put("name", name);
        result.put("age", age);
        result.put("tags", tags);
        result.put("location", location);

        // action.getPostBody().getData()     // Get full post data

        return result;
    }

}
