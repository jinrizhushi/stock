# stock
this is a stock project which is most about of the stock information that contains drawing ,showing and on.
## 股票系统 android

### 项目架构

#### 顶层模块划分

容器(Container)，主页(Home)，股票(Stock)，消息(Message)，个人信息(Personal)

#### 项目开发模式

1. MVVM 
2. 各模块间以 MVVM 方式分层，Model 对应原始数据模型(Raw Model)，View 对应视图及视图控制器，ViewModel 做为 Model 和 View 之间的对应协议。

### Container

程序容器视图，全局环境变量

### Home


### Message

### Personal

### 第三方库：

图形库：glide

网络库：volley

序列化：gson

注解：  androidannotations
       http://www.csdn123.com/html/topnews201408/29/729.htm

通信库：eventbus
       https://github.com/bboyfeiyu/AndroidEventBus