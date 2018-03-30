

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



### ActiveMQ

```doc

```



