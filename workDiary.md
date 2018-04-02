

# work diary



2018/3/28   星期三     晴

### 获取request

```java
		System.err.println("all--"+request.getQueryString());
		System.err.println("请求方式--"+request.getMethod());
		System.err.println("请求资源--"+request.getRequestURI());
		System.err.println("请求http协议版本--"+request.getProtocol());
		System.err.println("根据name,获取对应请求头数据--"+request.getHeader("Cookie"));
		System.err.println("获取所有的请求头名称--"+request.getHeaderNames());
		System.err.println("获取所有参数名称列表--"+request.getParameterNames());
```



### 数据转换成Json

```java
Map 转成 Json
1. json-lib
   Map map = new HashMap();  
   map.put("msg", "yes");//map里面装有yes  
   JSONObject jsonObject = JSONObject.fromObject(map);  

2. com.alibaba.fastjson.JSON
  JSONUtils.toJSONString(requestMap);

3.com.google.gson.2.2.2.jar 
  new Gson().toJson(param);

String转换成JSON
  String str = "{\"result\":\"success\",\"message\":\"成功！\"}";  
        JSONObject json = JSONObject.fromObject(str);  


```



### SocketServer 和 SocketClient

```java
Java Socket实现信息共享 - 聊天室
  客户端设计思路：客户端循环可以不停的输入消息，将消息发送给服务端，并开启一个线程监听服务端发过来的消息并进行处理，接收到的消息打印在控制台上。还可以输入特殊的命令，如果输入viewuser，则获取聊天室在线成员列表，输入quit，则申请退出聊天室。
  服务端设计思路：服务端启动时，启动一个队列监听器去监听聊天室内任何一个成员推送一条消息时，将消息发送给所有成员。每接收到一个客户端请求连接时，就新开一个线程进行处理，并将线程存放到线程集合中，将成员的端口后当做成员名称存放到公共的成员集合中。客户端所发送的所有消息都会存放到消息队列（ArrayBlockingQueue）中，队列监听器在队列中获取到消息后循环发送给聊天室内所有在线的成员，通知所有成员该消息是谁发送的，消息内容是什么。
  
```



### String 类中的字符串包含方法

```java
1. java 判断一个字符串是否包含某个字符 contains
   String str = "abc";  
   boolean status = str.contains("a"); 
2. 判断一个字符串中是否包含某个字符串。indexOf
  String str1 = "abcdefg"; 
   int result1 = str1.indexOf("abc");  
    if(result1 != -1){  
        System.out.println("字符串str中包含子串“abc”"+result1);  
    }else{  
        System.out.println("字符串str中不包含子串“abc”"+result1);  
    }  
  
```



2018/3/29    星期四  晴

### Git与Github的连接与使用

```doc
一.使用git 将项目上传到GitHub上

因为本地Git仓库和GitHub仓库之间的传输是通过SSH加密传输的，GitHub需要识别是否是你推送，GitHub只要知道了你的公钥，就可以确认只有你自己才能推送，所以需要配置ssh key。

1.创建SSH Key。

在用户主目录（C:\Users\Administrator）下，看看有没有.ssh文件，如果有，再看文件下有没有id_rsa和id_rsa.pub这两个文件，如果已经有了，可直接到下一步。如果没有，打开Git Bash，输入命令，创建SSH Key

$ ssh-keygen -t rsa -C "123@126.com" //123 是你自己注册GitHub的邮箱

创建成功啦，再去用户主目录里找到.ssh文件夹，里面有id_rsa和id_rsa.pub两个文件，这两个就是SSH Key的秘钥对，id_rsa是私钥，不能泄露，id_rsa.pub是公钥，可以公开。

2.接下来到GitHub上，打开“Account settings”--“SSH Keys”页面，然后点击“Add SSH Key”，填上Title（随意写），在Key文本框里粘贴 id_rsa.pub文件里的全部内容。

3.验证是否成功，在git bash里输入下面的命令
ssh -T git@github.com
如果初次设置的话，会出现如下界面，输入yes 同意即可

4.下面开始设置username和email，因为github每次commit都会记录他们
 git config --global user.name  "name"//你的GitHub登陆名
 git config --global user.email "123@126.com"//你的GitHub注册邮箱

5.接下来就是把本地仓库传到github上去，之前在GitHub上建好一个新的仓库是，跳转的页面，完全按照上面的只是操作就可以了。
git remote add origin git@github.com:flora0103/example.git    //关联一个远程库命令， git@github.com:flora0103/example.git   这个是自己远程库
git push -u origin master    //关联后,第一次推送master分支的所有内容命令，此后，每次本地提交后，就可以使用命令git push origin master推送最新修改




```

## Exception

```doc
1.java.io.IOException: 文件名、目录名或卷标语法不正确。
解决：文件命名有问题。

Windows 中文件夹命名规则是： 
① 文件名或文件夹名可以由1～256个西文字符或128个汉字（包括空格）组成，不能多于256个字符。 
② 文件名可以有扩展名，也可以没有。有些情况下系统会为文件自动添加扩展名。一般情况下，文件名与扩展名中间用符号“.”分隔。 
③ 文件名和文件夹名可以由字母、数字、汉字或~、!、@、#、$、%、^、&、( )、_、-、{}、’等组合而成。 
④ 可以有空格，可以有多于一个的圆点。 
⑤ 文件名或文件夹名中不能出现以下字符：\、/、:、*、?、"、<、>、| 。 
⑥ 不区分英文字母大小写。 



```



2018/3/30   星期五  阴

### java  获取tomcat下目录

```doc

String path = request.getSession().getServletContext().getRealPath("/"); 
			// path:D:\Arvin\AreaCode\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\wtpwebapps\IHAD-master\
			String headSculpturePath = request.getSession().getServletContext().getRealPath("/upload")+"/";
			// D:\Arvin\AreaCode\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\wtpwebapps\IHAD-master\upload/
			String nodepath = this.getClass().getClassLoader().getResource("/").getPath();  
			// nodepath:/D:/Arvin/AreaCode/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/IHAD-master/WEB-INF/classes/
			//String temporaryDirectory = request.getSession().getServletContext().getRealPath("/WEB-INF/upload/temporary_directory/" +"pengyue"+uuid+sdfn.format(new Date()));
```







### socket长连接与短连接

```java
短连接

连接->传输数据->关闭连接

HTTP是无状态的，浏览器和服务器每进行一次HTTP操作，就建立一次连接，但任务结束后就中断连接。短连接是指SOCKET连接后发送后接收完数据后马上断开连接

长连接

连接->传输数据->保持连接->传输数据->....->关闭连接

长连接指建立SOCKET连接后不管是否使用都保持连接，但安全性较差。

http的长连接

HTTP也可以建立长连接的，使用Connection:keep-alive,HTTP1.1默认进行持久连接。HTTP1.1和HTTP1.0相比较而言，最大的区别就是增加了持久连接支持，但还是无状态的，或者说是不可以信任的。

那什么场景下使用长连接或者短连接？

长连接多用于操作频繁，点对点的通讯(及时通讯)，而且连接数不能太多。每个TCP连接都需要三次握手，建立连接，会比较耗时。如果每个操作都要先连接，再操作的话，处理速度会降低很多。长连接的特点是每个操作完后都不断开连接，直接发送数据包就可以了，不需要每次都建立连接。
  
一、长连接和短连接的概念

　　1、长连接与短连接的概念：前者是整个通讯过程，客户端和服务端只用一个Socket对象，长期保持Socket的连接；后者是每次请求，都新建一个Socket,处理完一个请求就直接关闭掉Socket。所以，其实区分长短连接就是：整个客户和服务端的通讯过程是利用一个Socket还是多个Socket进行的。

　　可能你会想：这还不简单，长连接不就是不关Socket嘛，短连接不就是每次都关Socket每次都new Socket嘛。然而事实其实并没有那么简单的，请继续看下面的整理
  
  
  在关闭了对应的流（无论是输出或者输入）之后，下一次调用getInputStream或者getOutputStream会抛出异常说：Socket is closed；这里讲明一个事实：Socket和流联系着，流关闭了，Socket其实也就相当于关闭状态！

　　其实这个也很好理解，Socket本来就是依靠流进行关闭的，流，就只有一个，你关闭了流，Socket赖以通讯的渠道也就关闭了，与客户的连接也断开了，所以抛出异常是很合理的。

　　所以，流关闭而要求Socket正常通讯是不可能的！
  
总结  
1、对应流关闭，Socket的对应输入（出）数据的通道也就关闭，此时无法达到长连接效果；
2、关闭Socket，记得显式关闭流与socket,顺序是线管流再关socket.

3、要实先长连接，一般需要发送结束标记符号来告诉客户端服务端的某段消息已经发送完毕，否则客户端会一直阻塞在read方法。


```

## Java 流(Stream)、文件(File)和IO 



```java
Java.io 包几乎包含了所有操作输入、输出需要的类。所有这些流类代表了输入源和输出目标。
Java.io 包中的流支持很多种格式，比如：基本类型、对象、本地化字符集等等。
一个流可以理解为一个数据的序列。
输入流表示从一个源读取数据，输出流表示向一个目标写数据。
Java 为 I/O 提供了强大的而灵活的支持，使其更广泛地应用到文件传输和网络编程中。
Reader 字符流    Stream 字节流

```



#### 读取控制台输入

```doc
Java 的控制台输入由 System.in 完成。
为了获得一个绑定到控制台的字符流，
你可以把 System.in 包装在一个 BufferedReader 对象中来创建一个字符流。

创建 BufferedReader 的基本语法：
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
BufferedReader 对象创建后，我们便可以使用 read() 方法从控制台读取一个字符，或者用 readLine() 方法读取一个字符串。
从控制台读取多字符输入
从 BufferedReader 对象读取一个字符要使用 read() 方法
int read( ) throws IOException
每次调用 read() 方法，它从输入流读取一个字符并把该字符作为整数值返回。 当流结束的时候返回 -1。该方法抛出 IOException。
程序示范了用 read() 方法从控制台不断读取字符直到用户输入 "q"。

从控制台读取字符串
从标准输入读取一个字符串需要使用 BufferedReader 的 readLine() 方法。

它的一般格式是：

String readLine( ) throws IOException
下面的程序读取和显示字符行直到你输入了单词"end"。

控制台输出
在此前已经介绍过，控制台的输出由 print( ) 和 println() 完成。这些方法都由类 PrintStream 定义，System.out 是该类对象的一个引用。

PrintStream 继承了 OutputStream类，并且实现了方法 write()。这样，write() 也可以用来往控制台写操作。

PrintStream 定义 write() 的最简单格式如下所示：

void write(int byteval)
该方法将 byteval 的低八位字节写到流中。



```

```java
public class BufferedReaderRead {
	public static void main(String[] args) throws IOException {
		char c;
		// 使用System.in 创建 BufferReader 字符流
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.err.println("输入q退出");
		do {
			c = (char)bufferedReader.read();
			System.out.println(c);
		}while(c!='q');
		
	}
}


public class BufferedReaderReadLine {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String test;
		System.out.println("Enter 'end' to quit.");
		do {
			test = br.readLine();
			System.err.println(test);
		} while (!test.equals("end"));

	}
}

```

#### FileInputStream 

字节流，输入流 ，读取文件

```doc

该流用于从文件读取数据，它的对象可以用关键字 new 来创建。
可以使用字符串类型的文件名来创建一个输入流对象来读取文件：
InputStream f = new FileInputStream("C:/java/hello");

也可以使用一个文件对象来创建一个输入流对象来读取文件。我们首先得使用 File() 方法来创建一个文件对象：

File f = new File("C:/java/hello");
InputStream out = new FileInputStream(f);

创建了InputStream对象，就可以使用下面的方法来读取流或者进行其他的流操作。

public void close() throws IOException{}
关闭此文件输入流并释放与此流有关的所有系统资源。抛出IOException异常。

protected void finalize()throws IOException {}
这个方法清除与该文件的连接。确保在不再引用文件输入流时调用其 close 方法。抛出IOException异常。

public int read(int r)throws IOException{}
这个方法从 InputStream 对象读取指定字节的数据。返回为整数值。返回下一字节数据，如果已经到结尾则返回-1。

public int read(byte[] r) throws IOException{}
这个方法从输入流读取r.length长度的字节。返回读取的字节数。如果是文件结尾则返回-1。

public int available() throws IOException{}
返回下一次对此输入流调用的方法可以不受阻塞地从此输入流读取的字节数。返回一个整数值。


```

#### FileOutputStream

字节流，输出流，向文件写数据。

```doc
该类用来创建一个文件并向文件中写数据。

如果该流在打开文件进行输出前，目标文件不存在，那么该流会创建该文件。

有两个构造方法可以用来创建 FileOutputStream 对象。

使用字符串类型的文件名来创建一个输出流对象：
OutputStream f = new FileOutputStream("C:/java/hello")

也可以使用一个文件对象来创建一个输出流来写文件。我们首先得使用File()方法来创建一个文件对象：

File f = new File("C:/java/hello");
OutputStream f = new FileOutputStream(f);

创建OutputStream 对象完成后，就可以使用下面的方法来写入流或者进行其他的流操作。

public void close() throws IOException{}
关闭此文件输入流并释放与此流有关的所有系统资源。抛出IOException异常。

protected void finalize()throws IOException {}
这个方法清除与该文件的连接。确保在不再引用文件输入流时调用其 close 方法。抛出IOException异常。

public void write(int w)throws IOException{}
这个方法把指定的字节写到输出流中。

public void write(byte[] w)
把指定数组中w.length长度的字节写到OutputStream中。


```

```java
public class FileStream666 {
	public static void main(String[] args) throws IOException {

		File f = new File("D:\\output.txt");
		FileOutputStream fop = new FileOutputStream(f);
		// 构建FileOutputStream对象,文件不存在会自动新建

		OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
		// 构建OutputStreamWriter对象,参数可以指定编码,默认为操作系统默认编码,windows上是gbk

		writer.append("中文输入");
		// 写入到缓冲区

		writer.append("\r\n");
		// 换行

		writer.append("English");
		// 刷新缓存冲,写入到文件,如果下面已经没有写入的内容了,直接close也会写入

		writer.close();
		// 关闭写入流,同时会把缓冲区内容写入文件,所以上面的注释掉

		fop.close();
		// 关闭输出流,释放系统资源

		FileInputStream fip = new FileInputStream(f);
		// 构建FileInputStream对象

		InputStreamReader reader = new InputStreamReader(fip, "UTF-8");
		// 构建InputStreamReader对象,编码与写入相同

		StringBuffer sb = new StringBuffer();
		while (reader.ready()) {
			sb.append((char) reader.read());
			// 转成char加到StringBuffer对象中
		}
		System.out.println(sb.toString());
		reader.close();
		// 关闭读取流

		fip.close();
		// 关闭输入流,释放系统资源

	}
}
```



#### Java中的目录

```doc
File类中有两个方法可以用来创建文件夹：

mkdir( )方法创建一个文件夹，成功则返回true，失败则返回false。
失败表明File对象指定的路径已经存在，或者由于整个路径还不存在，该文件夹不能被创建。
mkdirs()方法创建一个文件夹和它的所有父文件夹。

import java.io.File;
 
public class CreateDir {
  public static void main(String args[]) {
    String dirname = "/tmp/user/java/bin";
    File d = new File(dirname);
    // 现在创建目录
    d.mkdirs();
  }
}

读取目录
一个目录其实就是一个 File 对象，它包含其他文件和文件夹。
如果创建一个 File 对象并且它是一个目录，那么调用 isDirectory() 方法会返回 true。
可以通过调用该对象上的 list() 方法，来提取它包含的文件和文件夹的列表。

下面展示的例子说明如何使用 list() 方法来检查一个文件夹中包含的内容：
import java.io.File;
 
public class DirList {
  public static void main(String args[]) {
    String dirname = "/tmp";
    File f1 = new File(dirname);
    if (f1.isDirectory()) {
      System.out.println( "目录 " + dirname);
      String s[] = f1.list();
      for (int i=0; i < s.length; i++) {
        File f = new File(dirname + "/" + s[i]);
        if (f.isDirectory()) {
          System.out.println(s[i] + " 是一个目录");
        } else {
          System.out.println(s[i] + " 是一个文件");
        }
      }
    } else {
      System.out.println(dirname + " 不是一个目录");
    }
  }
}


删除目录或文件

删除文件可以使用 java.io.File.delete() 方法。
以下代码会删除目录/tmp/java/，即便目录不为空。

import java.io.File;
 
public class DeleteFileDemo {
  public static void main(String args[]) {
      // 这里修改为自己的测试目录
    File folder = new File("/tmp/java/");
    deleteFolder(folder);
  }
 
  //删除文件及目录
  public static void deleteFolder(File folder) {
    File[] files = folder.listFiles();
        if(files!=null) { 
            for(File f: files) {
                if(f.isDirectory()) {
                    deleteFolder(f);
                } else {
                    f.delete();
                }
            }
        }
        folder.delete();
    }
}
```



## Java IO

http://www.cnblogs.com/skywang12345/p/io_01.html

### Java IO简介

```doc
java io系统的设计初衷，就是为了实现“文件、控制台、网络设备”这些io设置的通信。例如，对于一个文件，我们可以打开文件，然后进行读取和写入。
在java 1.0中，java提供的类都是以字节(byte)为单位，例如，FileInputStream和FileOutputStream。而到了java 1.1，为了与国际化进行接轨，在java io中添加了许多以字符(Unicode)为单位进行操作的类。

在java io的称呼中，我们经常会提到“输入流”、“输出流”等等概念。首先，什么是流呢？
所谓“流”，就是一种抽象的数据的总称，它的本质是能够进行传输。
      a) 按照“流”的数据流向，可以将其化分为：输入流和输出流。
      b) 按照“流”中处理数据的单位，可以将其区分为：字节流和字符流。在java中，字节是占1个Byte，即8位；而字符是占2个Byte，即16位。而且，需要注意的是，java的字节是有符号类型，而字符是无符号类型！
```



### Java IO框架

```doc
1. 以字节为单位的输入流的框架


                  |--ByteArrayInputStream				
                  |--PipedInputStream
                  |							|DataInputStream 
inputStream-------|--FilterInputStream  ---
                  |							|BufferedInputStream 
                  |						|File
                  |--FileInputStream ---
                  |						|FileDescriptor 
                  |--ObjectInputStream


从中，我们可以看出。
(01) InputStream 是以字节为单位的输入流的超类。InputStream提供了read()接口从输入流中读取字节数据。
(02) ByteArrayInputStream 是字节数组输入流。它包含一个内部缓冲区，该缓冲区包含从流中读取的字节；通俗点说，它的内部缓冲区就是一个字节数组，而ByteArrayInputStream本质就是通过字节数组来实现的。
(03) PipedInputStream 是管道输入流，它和PipedOutputStream一起使用，能实现多线程间的管道通信。
(04) FilterInputStream 是过滤输入流。它是DataInputStream和BufferedInputStream的超类。
(05) DataInputStream 是数据输入流。它是用来装饰其它输入流，它“允许应用程序以与机器无关方式从底层输入流中读取基本 Java 数据类型”。
(06) BufferedInputStream 是缓冲输入流。它的作用是为另一个输入流添加缓冲功能。
(07) File 是“文件”和“目录路径名”的抽象表示形式。关于File，注意两点：
a), File不仅仅只是表示文件，它也可以表示目录！
b), File虽然在io保重定义，但是它的超类是Object，而不是InputStream。
(08) FileDescriptor 是“文件描述符”。它可以被用来表示开放文件、开放套接字等。
(09) FileInputStream 是文件输入流。它通常用于对文件进行读取操作。
(10) ObjectInputStream 是对象输入流。它和ObjectOutputStream一起，用来提供对“基本数据或对象”的持久存储。



2.以字节为单位的输出流的框架图



                  |--ByteArrayOutputStream				
                  |--PipedOutputStream
                  |							|DataOutputStream 
OutputStream-------|--FilterOutputStream  ---
                  |							|BufferedOutputStream 
                  |						|File
                  |--FileOutputStream ---
                  |						|FileDescriptor 
                  |--ObjectOutputStream


从中，我们可以看出。以字节为单位的输出流的公共父类是OutputStream。
(01) OutputStream 是以字节为单位的输出流的超类。OutputStream提供了write()接口从输出流中读取字节数据。
(02) ByteArrayOutputStream 是字节数组输出流。写入ByteArrayOutputStream的数据被写入一个 byte 数组。缓冲区会随着数据的不断写入而自动增长。可使用 toByteArray() 和 toString() 获取数据。
(03) PipedOutputStream 是管道输出流，它和PipedInputStream一起使用，能实现多线程间的管道通信。
(04) FilterOutputStream 是过滤输出流。它是DataOutputStream，BufferedOutputStream和PrintStream的超类。
(05) DataOutputStream 是数据输出流。它是用来装饰其它输出流，它“允许应用程序以与机器无关方式向底层写入基本 Java 数据类型”。
(06) BufferedOutputStream 是缓冲输出流。它的作用是为另一个输出流添加缓冲功能。
(07) PrintStream 是打印输出流。它是用来装饰其它输出流，能为其他输出流添加了功能，使它们能够方便地打印各种数据值表示形式。
(08) FileOutputStream 是文件输出流。它通常用于向文件进行写入操作。
(09) ObjectOutputStream 是对象输出流。它和ObjectInputStream一起，用来提供对“基本数据或对象”的持久存储。




3.以字符为单位的输入流的框架图
下面，是以字符为单位的输入流的框架图。

          |CharArrayReader 
          |PipedReader 
          |FilterReader 
Reader----
          |BufferedReader 
          |InputStreamReader <--FileReader-->File
          
从中，我们可以看出。以字符为单位的输入流的公共父类是Reader。
(01) Reader 是以字符为单位的输入流的超类。它提供了read()接口来取字符数据。
(02) CharArrayReader 是字符数组输入流。它用于读取字符数组，它继承于Reader。操作的数据是以字符为单位！
(03) PipedReader 是字符类型的管道输入流。它和PipedWriter一起是可以通过管道进行线程间的通讯。在使用管道通信时，必须将PipedWriter和PipedReader配套使用。
(04) FilterReader 是字符类型的过滤输入流。
(05) BufferedReader 是字符缓冲输入流。它的作用是为另一个输入流添加缓冲功能。
(06) InputStreamReader 是字节转字符的输入流。它是字节流通向字符流的桥梁：它使用指定的 charset 读取字节并将其解码为字符。
(07) FileReader 是字符类型的文件输入流。它通常用于对文件进行读取操作。


4.以字符为单位的输出流的框架图

下面，是以字符为单位的输出流的框架图。





          |CharArrayWriter 
          |PipedWriter 
          |FilterWriter 
Writer----
          |BufferedWriter
          |InputStreamWriter <--FileWriter-->File
          |PrintWriter

(01) Writer 是以字符为单位的输出流的超类。它提供了write()接口往其中写入数据。
(02) CharArrayWriter 是字符数组输出流。它用于读取字符数组，它继承于Writer。操作的数据是以字符为单位！
(03) PipedWriter 是字符类型的管道输出流。它和PipedReader一起是可以通过管道进行线程间的通讯。在使用管道通信时，必须将PipedWriter和PipedWriter配套使用。
(04) FilterWriter 是字符类型的过滤输出流。
(05) BufferedWriter 是字符缓冲输出流。它的作用是为另一个输出流添加缓冲功能。
(06) OutputStreamWriter 是字节转字符的输出流。它是字节流通向字符流的桥梁：它使用指定的 charset 将字节转换为字符并写入。
(07) FileWriter 是字符类型的文件输出流。它通常用于对文件进行读取操作。
(08) PrintWriter 是字符类型的打印输出流。它是用来装饰其它输出流，能为其他输出流添加了功能，使它们能够方便地打印各种数据值表示形式。



5.字节转换为字符流的框架图

在java中，字节流能转换为字符流，下面是它们的转换关系图。
File<-----依赖----FileInputStream<---依赖---InputStreamReader<----继承---FileReader

从中，我们可以看出。
(01) FileReader继承于InputStreamReader，而InputStreamReader依赖于InputStream。具体表现在InputStreamReader的构造函数是以InputStream为参数。我们传入InputStream，在InputStreamReader内部通过转码，将字节转换成字符。
(02) FileWriter继承于OutputStreamWriter，而OutputStreamWriter依赖于OutputStream。具体表现在OutputStreamWriter的构造函数是以OutputStream为参数。我们传入OutputStream，在OutputStreamWriter内部通过转码，将字节转换成字符。



```



## 事务

```doc
事务是为了保证对同一数据表操作的一致性。
即多条语句放在事务中执行的时候，要么一起成功，要么全不成功。如果想看严格定义，就去随便找一本数据库教材看看吧。
我只说我的理解：数据库中的事务就是需要捆绑在一起执行的操作集合，他们应不能被部分的完成。
虽然事务并不都是用在数据库中的，但他们都有以下共同性质
事务应当具有ACID性质，
A是原子性(atomic)：事务中包含的各项操作必须全部成功执行或者全部不执行。任何一项操作失败，将导致整个事务失败，其他已经执行的任务所作的数据操作都将被撤销，只有所有的操作全部成功，整个事务才算是成功完成。
C是一致性(consistent)：保证了当事务结束后，系统状态是一致的。那么什么是一致的系统状态？例如，如果银行始终遵循着"银行账号必须保持正态平衡"的原则，那么银行系统的状态就是一致的。上面的转账例子中，在取钱的过程中，账户会出现负态平衡，在事务结束之后，系统又回到一致的状态。这样，系统的状态对于客户来说，始终是一致的。
I是隔离性(isolated)：使得并发执行的事务，彼此无法看到对方的中间状态。保证了并发执行的事务顺序执行，而不会导致系统状态不一致。
D是持久性(durable)：保证了事务完成后所作的改动都会被持久化，即使是发生灾难性的失败。可恢复性资源保存了一份事务日志，如果资源发生故障，可以通过日志来将数据重建起来。
```





### JAVA 消息队列

消息队列解决的是将突发大量请求转换为后端能承受的队列请求

```doc
消息队列的使用场景是怎样的？
经常听到诸如rebbitmq,activemq，请教一下各位前辈消息队列的使用场景是怎样的，什么时候会用到它
 
校验用户名等信息，如果没问题会在数据库中添加一个用户记录
如果是用邮箱注册会给你发送一封注册成功的邮件，手机注册则会发送一条短信
分析用户的个人信息，以便将来向他推荐一些志同道合的人，或向那些人推荐他
发送给用户一个包含操作指南的系统通知
等等……

除了这些之外，比较常用的就是起到消峰时需要用到：
比如你的服务器一秒能处理100个订单，但秒杀活动1秒进来1000个订单，持续10秒，在后端能力无法增加的情况下，你可以用消息队列将总共10000个请求压在队列里，后台consumer按原有能力处理，100秒后处理完所有请求（而不是直接宕机丢失订单数据）。

消息队列的主要特点是异步处理，主要目的是减少请求响应时间和解耦。所以主要的使用场景就是将比较耗时而且不需要即时（同步）返回结果的操作作为消息放入消息队列。同时由于使用了消息队列，只要保证消息格式不变，消息的发送方和接收方并不需要彼此联系，也不需要受对方的影响，即解耦和。

使用场景的话，举个例子：
假设用户在你的软件中注册，服务端收到用户的注册请求后，它会做这些操作：
校验用户名等信息，如果没问题会在数据库中添加一个用户记录
如果是用邮箱注册会给你发送一封注册成功的邮件，手机注册则会发送一条短信
分析用户的个人信息，以便将来向他推荐一些志同道合的人，或向那些人推荐他
发送给用户一个包含操作指南的系统通知
等等……
但是对于用户来说，注册功能实际只需要第一步，只要服务端将他的账户信息存到数据库中他便可以登录上去做他想做的事情了。至于其他的事情，非要在这一次请求中全部完成么？值得用户浪费时间等你处理这些对他来说无关紧要的事情么？所以实际当第一步做完后，服务端就可以把其他的操作放入对应的消息队列中然后马上返回用户结果，由消息队列异步的进行这些操作。

或者还有一种情况，同时有大量用户注册你的软件，再高并发情况下注册请求开始出现一些问题，例如邮件接口承受不住，或是分析信息时的大量计算使cpu满载，这将会出现虽然用户数据记录很快的添加到数据库中了，但是却卡在发邮件或分析信息时的情况，导致请求的响应时间大幅增长，甚至出现超时，这就有点不划算了。面对这种情况一般也是将这些操作放入消息队列（生产者消费者模型），消息队列慢慢的进行处理，同时可以很快的完成注册请求，不会影响用户使用其他功能。

所以在软件的正常功能开发中，并不需要去刻意的寻找消息队列的使用场景，而是当出现性能瓶颈时，去查看业务逻辑是否存在可以异步处理的耗时操作，如果存在的话便可以引入消息队列来解决。否则盲目的使用消息队列可能会增加维护和开发的成本却无法得到可观的性能提升，那就得不偿失了。
 
 
 
我可以举个小例子先说明应用场景

假设你的服务器每分钟的处理量为200个，但客户端再峰值的时候可能一分钟会发1000个消息给你，这时候你就可以把他做成队列，然后按正常有序的处理，先进后出(LIFO)，先进先出(FIFO）可根据自己的情况进行定夺

stack  先进后出(LIFO)--------java 对应的类 Stack

队列 先进先出(FIFO）--------java对应的类Queue



/** 
 * 
 * --------->>>>>>队列的实现-------------- 
 */  
public class MyStack<T> {  
    private LinkedList<T> storage = new LinkedList<T>();  
  
    public synchronized void push(T e) {//需要加上同步  
        storage.addFirst(e);  
    }  
  
    public T peek() {  
        return storage.getFirst();  
    }  
  
    public void pop() {  
        storage.removeFirst();  
    }  
  
    public boolean empty() {  
        return storage.isEmpty();  
    }  
  
    @Override  
    public String toString() {  
        return storage.toString();  
    }  
  
}  


```





## Java消息队列

https://www.cnblogs.com/doit8791/p/7759806.html

### 一、消息队列概述

```doc
消息队列中间件是分布式系统中重要的组件，主要解决应用解耦，异步消息，流量削锋等问题，实现高性能，高可用，可伸缩和最终一致性架构。目前使用较多的消息队列有ActiveMQ，RabbitMQ，ZeroMQ，Kafka，MetaMQ，RocketMQ
```



### 二、消息队列应用场景

以下介绍消息队列在实际应用中常用的使用场景。异步处理，应用解耦，流量削锋和消息通讯四个场景。



#### 2.1异步处理

场景说明：用户注册后，需要发注册邮件和注册短信。传统的做法有两种 1.串行的方式；2.并行方式
a、串行方式：将注册信息写入数据库成功后，发送注册邮件，再发送注册短信。以上三个任务全部完成后，返回给客户端。

b、并行方式：将注册信息写入数据库成功后，发送注册邮件的同时，发送注册短信。以上三个任务完成后，返回给客户端。与串行的差别是，并行的方式可以提高处理的时间。



假设三个业务节点每个使用50毫秒钟，不考虑网络等其他开销，则串行方式的时间是150毫秒，并行的时间可能是100毫秒。
因为CPU在单位时间内处理的请求数是一定的，假设CPU1秒内吞吐量是100次。则串行方式1秒内CPU可处理的请求量是7次（1000/150）。并行方式处理的请求量是10次（1000/100）
小结：如以上案例描述，传统的方式系统的性能（并发量，吞吐量，响应时间）会有瓶颈。如何解决这个问题呢？



引入消息队列，将不是必须的业务逻辑，异步处理。改造后的架构如下

按照以上约定，用户的响应时间相当于是注册信息写入数据库的时间，也就是50毫秒。注册邮件，发送短信写入消息队列后，直接返回，因此写入消息队列的速度很快，基本可以忽略，因此用户的响应时间可能是50毫秒。因此架构改变后，系统的吞吐量提高到每秒20 QPS。比串行提高了3倍，比并行提高了两倍。





#### 2.2应用解耦

场景说明：用户下单后，订单系统需要通知库存系统。传统的做法是，订单系统调用库存系统的接口。

传统模式的缺点：假如库存系统无法访问，则订单减库存将失败，从而导致订单失败，订单系统与库存系统耦合。

如何解决以上问题呢？引入应用消息队列后的方案，

订单系统：用户下单后，订单系统完成持久化处理，将消息写入消息队列，返回用户订单下单成功
库存系统：订阅下单的消息，采用拉/推的方式，获取下单信息，库存系统根据下单信息，进行库存操作
假如：在下单时库存系统不能正常使用。也不影响正常下单，因为下单后，订单系统写入消息队列就不再关心其他的后续操作了。实现订单系统与库存系统的应用解耦。

#### 2.3流量削锋

流量削锋也是消息队列中的常用场景，一般在秒杀或团抢活动中使用广泛。
应用场景：秒杀活动，一般会因为流量过大，导致流量暴增，应用挂掉。为解决这个问题，一般需要在应用前端加入消息队列。
a、可以控制活动的人数
b、可以缓解短时间内高流量压垮应用

用户的请求，服务器接收后，首先写入消息队列。假如消息队列长度超过最大数量，则直接抛弃用户请求或跳转到错误页面。
秒杀业务根据消息队列中的请求信息，再做后续处理

#### 2.4日志处理

日志处理是指将消息队列用在日志处理中，比如Kafka的应用，解决大量日志传输的问题。

日志采集客户端，负责日志数据采集，定时写受写入Kafka队列
Kafka消息队列，负责日志数据的接收，存储和转发
日志处理应用：订阅并消费kafka队列中的日志数据 

#### 2.5消息通讯

消息通讯是指，消息队列一般都内置了高效的通信机制，因此也可以用在纯的消息通讯。比如实现点对点消息队列，或者聊天室等
点对点通讯：

客户端A（发消息）和客户端B（收消息）使用同一消息队列，进行消息通讯。



聊天室通讯：

客户端A，客户端B，客户端N订阅同一主题，进行消息发布和接收。实现类似聊天室效果。



以上实际是消息队列的两种消息模式，点对点或发布订阅模式。

### 三、消息中间件示例

3.1电商系统



消息队列采用高可用，可持久化的消息中间件。比如Active MQ，Rabbit MQ，Rocket Mq。

消息队列采用高可用，可持久化的消息中间件。比如Active MQ，Rabbit MQ，Rocket Mq。
（1）应用将主干逻辑处理完成后，写入消息队列。消息发送是否成功可以开启消息的确认模式。（消息队列返回消息接收成功状态后，应用再返回，这样保障消息的完整性）
（2）扩展流程（发短信，配送处理）订阅队列消息。采用推或拉的方式获取消息并处理。
（3）消息将应用解耦的同时，带来了数据一致性问题，可以采用最终一致性方式解决。比如主数据写入数据库，扩展应用根据消息队列，并结合数据库方式实现基于消息队列的后续处理。



分为Zookeeper注册中心，日志收集客户端，Kafka集群和Storm集群（OtherApp）四部分组成。
Zookeeper注册中心，提出负载均衡和地址查找服务
日志收集客户端，用于采集应用系统的日志，并将数据推送到kafka队列
Kafka集群：接收，路由，存储，转发等消息处理
Storm集群：与OtherApp处于同一级别，采用拉的方式消费队列中的数据

### 四、JMS消息服务



讲消息队列就不得不提JMS 。JMS（JAVA Message Service，java消息服务）API是一个消息服务的标准/规范，允许应用程序组件基于JavaEE平台创建、发送、接收和读取消息。它使分布式通信耦合度更低，消息服务更加可靠以及异步性。
在EJB架构中，有消息bean可以无缝的与JM消息服务集成。在J2EE架构模式中，有消息服务者模式，用于实现消息与应用直接的解耦。

#### 4.1消息模型

在JMS标准中，有两种消息模型P2P（Point to Point）,Publish/Subscribe(Pub/Sub)。P2P模式包含三个角色：消息队列（Queue），发送者(Sender)，接收者(Receiver)。每个消息都被发送到一个特定的队列，接收者从队列中获取消息。队列保留着消息，直到他们被消费或超时。

P2P的特点
每个消息只有一个消费者（Consumer）(即一旦被消费，消息就不再在消息队列中)
发送者和接收者之间在时间上没有依赖性，也就是说当发送者发送了消息之后，不管接收者有没有正在运行，它不会影响到消息被发送到队列
接收者在成功接收消息之后需向队列应答成功 
如果希望发送的每个消息都会被成功处理的话，那么需要P2P模式。

##### 4.1.2 Pub/Sub模式

包含三个角色主题（Topic），发布者（Publisher），订阅者（Subscriber） 多个发布者将消息发送到Topic，系统将这些消息传递给多个订阅者。

Pub/Sub的特点
每个消息可以有多个消费者
发布者和订阅者之间有时间上的依赖性。针对某个主题（Topic）的订阅者，它必须创建一个订阅者之后，才能消费发布者的消息
为了消费消息，订阅者必须保持运行的状态
为了缓和这样严格的时间相关性，JMS允许订阅者创建一个可持久化的订阅。这样，即使订阅者没有被激活（运行），它也能接收到发布者的消息。
如果希望发送的消息可以不被做任何处理、或者只被一个消息者处理、或者可以被多个消费者处理的话，那么可以采用Pub/Sub模型。

#### 4.2消息消费

在JMS中，消息的产生和消费都是异步的。对于消费来说，JMS的消息者可以通过两种方式来消费消息。
（1）同步
订阅者或接收者通过receive方法来接收消息，receive方法在接收到消息之前（或超时之前）将一直阻塞；

（2）异步
订阅者或接收者可以注册为一个消息监听器。当消息到达之后，系统自动调用监听器的onMessage方法。

JNDI：Java命名和目录接口,是一种标准的Java命名系统接口。可以在网络上查找和访问服务。通过指定一个资源名称，该名称对应于数据库或命名服务中的一个记录，同时返回资源连接建立所必须的信息。
JNDI在JMS中起到查找和访问发送目标或消息来源的作用。

### 五、常用消息队列

一般商用的容器，比如WebLogic，JBoss，都支持JMS标准，开发上很方便。但免费的比如Tomcat，Jetty等则需要使用第三方的消息中间件。本部分内容介绍常用的消息中间件（Active MQ,Rabbit MQ，Zero MQ,Kafka）以及他们的特点。

#### 5.1 ActiveMQ



ActiveMQ默认启动时，启动了内置的jetty服务器，提供一个用于监控ActiveMQ的admin应用。 
http://127.0.0.1:8161/admin/

默认账号：admin

　　密码：admin

ActiveMQ 是Apache出品，最流行的，能力强劲的开源消息总线。ActiveMQ 是一个完全支持JMS1.1和J2EE 1.4规范的 JMS Provider实现，尽管JMS规范出台已经是很久的事情了，但是JMS在当今的J2EE应用中间仍然扮演着特殊的地位。

ActiveMQ特性如下：
⒈ 多种语言和协议编写客户端。语言: Java,C,C++,C#,Ruby,Perl,Python,PHP。应用协议： OpenWire,Stomp REST,WS Notification,XMPP,AMQP
⒉ 完全支持JMS1.1和J2EE 1.4规范 （持久化，XA消息，事务)
⒊ 对Spring的支持，ActiveMQ可以很容易内嵌到使用Spring的系统里面去，而且也支持Spring2.0的特性
⒋ 通过了常见J2EE服务器（如 Geronimo,JBoss 4,GlassFish,WebLogic)的测试，其中通过JCA 1.5 resource adaptors的配置，可以让ActiveMQ可以自动的部署到任何兼容J2EE 1.4 商业服务器上
⒌ 支持多种传送协议：in-VM,TCP,SSL,NIO,UDP,JGroups,JXTA
⒍ 支持通过JDBC和journal提供高速的消息持久化
⒎ 从设计上保证了高性能的集群，客户端-服务器，点对点
⒏ 支持Ajax
⒐ 支持与Axis的整合
⒑ 可以很容易得调用内嵌JMS provider，进行测试。





#### 5.2 Kafka

Kafka是一种高吞吐量的分布式发布订阅消息系统，它可以处理消费者规模的网站中的所有动作流数据。 这种动作（网页浏览，搜索和其他用户的行动）是在现代网络上的许多社会功能的一个关键因素。 这些数据通常是由于吞吐量的要求而通过处理日志和日志聚合来解决。 对于像Hadoop的一样的日志数据和离线分析系统，但又要求实时处理的限制，这是一个可行的解决方案。Kafka的目的是通过Hadoop的并行加载机制来统一线上和离线的消息处理，也是为了通过集群机来提供实时的消费。

Kafka是一种高吞吐量的分布式发布订阅消息系统，有如下特性：
通过O(1)的磁盘数据结构提供消息的持久化，这种结构对于即使数以TB的消息存储也能够保持长时间的稳定性能。（文件追加的方式写入数据，过期的数据定期删除）
高吞吐量：即使是非常普通的硬件Kafka也可以支持每秒数百万的消息
支持通过Kafka服务器和消费机集群来分区消息
支持Hadoop并行数据加载
Kafka相关概念
Broker
Kafka集群包含一个或多个服务器，这种服务器被称为broker[5]
Topic
每条发布到Kafka集群的消息都有一个类别，这个类别被称为Topic。（物理上不同Topic的消息分开存储，逻辑上一个Topic的消息虽然保存于一个或多个broker上但用户只需指定消息的Topic即可生产或消费数据而不必关心数据存于何处）
Partition
Parition是物理上的概念，每个Topic包含一个或多个Partition.
Producer
负责发布消息到Kafka broker
Consumer
消息消费者，向Kafka broker读取消息的客户端。
Consumer Group
每个Consumer属于一个特定的Consumer Group（可为每个Consumer指定group name，若不指定group name则属于默认的group）。
一般应用在大数据日志处理或对实时性（少量延迟），可靠性（少量丢数据）要求稍低的场景使用。





2018/4/2   星期一  多云

# 详解Java消息队列-Spring整合ActiveMq

### 一、Java消息队列----JMS概述

#### 1.什么是JMS?

JMS即Java消息服务（Java Message Service）应用程序接口。

```doc
是一个Java平台中关于面向消息中间件（MOM）的API，用于在两个应用程序之间，或分布式系统中发送消息，进行异步通信。Java消息服务是一个与具体平台无关的API，绝大多数MOM提供商都对JMS提供支持。

我们可以简单的理解：两个应用程序之间需要进行通信，我们使用一个JMS服务，进行中间的转发，通过JMS 的使用，我们可以解除两个程序之间的耦合。

```

#### 2、JMS的优势

Asynchronous（异步）

JMS 原本就是一个异步的消息服务，客户端获取消息的时候，不需要主动发送请求，消息会自动发送给可用的客户端



Reliable（可靠）

JMS保证消息只会递送一次。大家都遇到过重复创建消息问题，而JMS能帮你避免该问题。



#### 3、JMS的消息模型

　　　JMS具有两种通信模式：

　　　　　　1、Point-to-Point Messaging Domain （点对点）

　　　　　　2、Publish/Subscribe Messaging Domain （发布/订阅模式）



##### (1)、Point-to-Point Messaging Domain（点对点通信模型）

在点对点通信模式中，应用程序由消息队列，发送方，接收方组成。

每个消息都被发送到一个特定的队列，接收者从队列中获取消息。队列保留着消息，直到他们被消费或超时。

每个消息只要一个消费者
发送者和接收者在时间上是没有时间的约束，也就是说发送者在发送完消息之后，不管接收者有没有接受消息，都不会影响发送方发送消息到消息队列中。

发送方不管是否在发送消息，接收方都可以从消息队列中去到消息。

接收方在接收完消息之后，需要向消息队列应答成功。

##### (2)、Publish/Subscribe Messaging Domain（发布/订阅通信模型）

在发布/订阅消息模型中，发布者发布一个消息，该消息通过topic传递给所有的客户端。该模式下，发布者与订阅者都是匿名的，即发布者与订阅者都不知道对方是谁。并且可以动态的发布与订阅Topic。Topic主要用于保存和传递消息，且会一直保存消息直到消息被传递给客户端。

一个消息可以传递个多个订阅者（即：一个消息可以有多个接受方）
发布者与订阅者具有时间约束，针对某个主题（Topic）的订阅者，它必须创建一个订阅者之后，才能消费发布者的消息，而且为了消费消息，订阅者必须保持运行的状态。
为了缓和这样严格的时间相关性，JMS允许订阅者创建一个可持久化的订阅。这样，即使订阅者没有被激活（运行），它也能接收到发布者的消息。

#### 4、JMS接收消息

JMS中，消息的产生和消息是异步的。对于消费来说，JMS的消息者可以通过两种方式来消费消息。

##### （1）、同步（Synchronous）

　　　　　　　　在同步消费信息模式模式中，订阅者/接收方通过调用 receive（）方法来接收消息。在receive（）方法中，线程会阻塞直到消息到达或者到指定时间后消息仍未到达。

##### （2）、异步（Asynchronous）

　　　　　　　　使用异步方式接收消息的话，消息订阅者需注册一个消息监听者，类似于事件监听器，只要消息到达，JMS服务提供者会通过调用监听器的onMessage()递送消息。



#### 5、JMS编程模型　

1管理对象（Administered objects）-连接工厂（Connection Factories）和目的地（Destination）
2连接对象（Connections）
3会话（Sessions）
4消息生产者（Message Producers）
5消息消费者（Message Consumers）
6消息监听者（Message Listeners）



```doc
（1）、Connection Factories

　　　　　　　　创建Connection对象的工厂，针对两种不同的jms消息模型，分别有QueueConnectionFactory和TopicConnectionFactory两种。可以通过JNDI来查找ConnectionFactory对象。客户端使用一个连接工厂对象连接到JMS服务提供者，它创建了JMS服务提供者和客户端之间的连接。JMS客户端（如发送者或接受者）会在JNDI名字空间中搜索并获取该连接。使用该连接，客户端能够与目的地通讯，往队列或话题发送/接收消息。
QueueConnectionFactory queueConnFactory = (QueueConnectionFactory) initialCtx.lookup ("primaryQCF");
Queue purchaseQueue = (Queue) initialCtx.lookup ("Purchase_Queue");
Queue returnQueue = (Queue) initialCtx.lookup ("Return_Queue");

（2）、Destination

 　　　　　　　　目的地指明消息被发送的目的地以及客户端接收消息的来源。JMS使用两种目的地，队列和话题。如下代码指定了一个队列和话题：
 　　　　　　　　创建一个队列Session：
 　　　QueueSession ses = con.createQueueSession (false, Session.AUTO_ACKNOWLEDGE);  //get the Queue object  
Queue t = (Queue) ctx.lookup ("myQueue");  //create QueueReceiver  
QueueReceiver receiver = ses.createReceiver(t); 
　创建一个Topic Session：

QueueSession ses = con.createQueueSession (false, Session.AUTO_ACKNOWLEDGE);  //get the Queue object  
Queue t = (Queue) ctx.lookup ("myQueue");  //create QueueReceiver  
QueueReceiver receiver = ses.createReceiver(t); 

（3）、Connection

　　　　　　Connection表示在客户端和JMS系统之间建立的链接（对TCP/IP socket的包装）。Connection可以产生一个或多个Session。跟ConnectionFactory一样，Connection也有两种类型：QueueConnection和TopicConnection。

　　　　　　连接对象封装了与JMS提供者之间的虚拟连接，如果我们有一个ConnectionFactory对象，可以使用它来创建一个连接。
Connection connection = connectionFactory.createConnection();


Session 是我们对消息进行操作的接口，可以通过session创建生产者、消费者、消息等。Session 提供了事务的功能，如果需要使用session发送/接收多个消息时，可以将这些发送/接收动作放到一个事务中。

　　　　　　我们可以在连接创建完成之后创建session：

Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
　　　　　　这里面提供了参数两个参数，第一个参数是是否支持事务，第二个是事务的类型

（5）、Producter

　　　　　　消息生产者由Session创建，用于往目的地发送消息。生产者实现MessageProducer接口，我们可以为目的地、队列或话题创建生产者；

　　　　　　

MessageProducer producer = session.createProducer(dest);
MessageProducer producer = session.createProducer(queue);
MessageProducer producer = session.createProducer(topic);


　（6）、Consumer

　　　　　　消息消费者由Session创建，用于接收被发送到Destination的消息。

　

MessageConsumer consumer = session.createConsumer(dest);
MessageConsumer consumer = session.createConsumer(queue);
MessageConsumer consumer = session.createConsumer(topic);



（7）、MessageListener

　　　　　　消息监听器。如果注册了消息监听器，一旦消息到达，将自动调用监听器的onMessage方法。EJB中的MDB（Message-Driven Bean）就是一种MessageListener。

 
```



## Java 多线程

```doc

```

