（1）编写一个圆类Circle，该类拥有：

1.一个成员变量

Radius（私有，浮点型）;//存放圆的半径；

2.两个构造方法

Circle（）              //将半径设为0

Circle（double  r ）    //创建Circle对象时将半径初始化为r


3.三个成员方法

double getArea（）      //获取圆的面积

double getPerimeter（）  //获取圆的周长

void show（）           //将圆的关径、周长、面积输出到屏幕

（2） 编写一个圆柱体类Cylinder，它继承于上面的Circle类。还拥有：

1.一个成员变量

double hight  （私有，浮点型）;  //圆柱体的高；

2.构造方法

Cylinder（double r,double h）     //创建Cylinder对象时将半径初始化为r,高度初始化为h

3.成员方法

double getVolume（）            //获取圆柱体的体积

void showVolume（）             //将圆柱体的体积输出到屏幕