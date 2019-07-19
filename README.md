# OAuth2实现单点登录功能
来源：https://mp.weixin.qq.com/s/F6WQhsFhUfbIc5qvNkTlGw

SSO服务端和SSO客户端直接是通过授权以后发放Token的形式来访问受保护的资源

相对于浏览器来说，业务系统是服务端，相对于SSO服务端来说，业务系统是客户端

浏览器和业务系统之间通过会话正常访问

不是每次浏览器请求都要去SSO服务端去验证，只要浏览器和它所访问的服务端的会话有效它就可以正常访问

SSO是一种思想，或者说是一种解决方案，是抽象的，我们要做的就是按照它的这种思想去实现它；

其次，OAuth2是用来允许用户授权第三方应用访问他在另一个服务器上的资源的一种协议，它不是用来做单点登录的，但我们可以利用它来实现单点登录。

OAuth2服务端负责令牌的发放等操作，这令牌的生成我们采用JWT，也就是说JWT是用来承载用户的Access_Token的；

Spring Security是用于安全访问的，用来做访问权限控制。


## --------------------------
oauth2-sso-auth-server :服务端

oauth2-sso-client-member :客户端1

oauth2-sso-client-order :客户端2

源码github:https://github.com/chengjiansheng/cjs-oauth2-sso-demo
