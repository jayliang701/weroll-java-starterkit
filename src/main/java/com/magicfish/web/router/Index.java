package com.magicfish.web.router;

import com.magicfish.weroll.annotation.Router;
import com.magicfish.weroll.annotation.RouterGroup;

@RouterGroup
public class Index {

    @Router(path = "/", view = "/index", needLogin = false)
    public void renderDefaultHomePage() {
        renderIndexPage();
    }

    @Router(path = "/index", needLogin = false)
    public void renderIndexPage() {

    }

}
