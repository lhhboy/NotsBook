# NotsBook
日记本：
设计一个简单记事本，主要技术用到：litepal数据库保存用户账户密码，sharepreferens记住密码，RecyclerView显示数据
1.用RelativeLayout设计登录界面和注册界面；

2.创建数据库：
添加依赖：
implementation 'org.litepal.android:core:1.5.1'
创建assetsw文件夹，创建litepal.xml（注意：先创建file.xml，再改成litepal）
在AndroidManifest.xml注册： android:name="org.litepal.LitePalApplication"

3.了解"return;"知识点，后面代码不再执行，和break不一样，break只是结束当前循环，后面由代码还会往下执行；


