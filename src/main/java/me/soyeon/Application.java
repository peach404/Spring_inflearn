package me.soyeon;


import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.Context;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@SpringBootApplication
public class Application {

    public static void main(String[] args) throws LifecycleException {

        //서블릿 만들기
        //실제로는 이런 코드를 작성할 일이없다. 왜냐하면 autoconfiguration에 이 과정을 상세하게 설정하고 실행해주는 자동 설정이 존재한다.


       Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        Context context = tomcat.addContext("/","/");

        HttpServlet servlet = new HttpServlet() {
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                PrintWriter writer = resp.getWriter();
                writer.println("<html><head><title>");
                writer.println("Hey Tomcat");
                writer.println("</title></head>");
                writer.println("<body><h1>Hello,Tomcat</h1></body>");
                writer.println("</html>");

            }
        };

            String servletName = "helloServlet";
            tomcat.addServlet("/",servletName,servlet);
            context.addServletMappingDecoded("/hello",servletName);

            tomcat.start();
            tomcat.getServer().await();
    }


}
