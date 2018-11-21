## 자동 설정 이해하기!


## Bean 등록방식

@SpringBootApplication 이 붙은 클래스 파일이 그 클래스가 소속된 패키지 파일을 스캔한다.

### 스캔 방식
 1. @ComponentScan 을 읽어서 등록
 2. @EnableAutoConfiguration 을 읽어서 등록한다.

@Component 애노테이션을 찾아 빈으로 등록하는데 -@Controller, @Configuration, @Repository, @Service, @RestController 내부에도
Component 애노테이션이 숨어있으므로 빈으로 등록해준다.

## 자동 설정 파일 만들기

새로운 프로젝트를 생성해서 원하는 설정내용은 따로 클래스로 만들고 Spring.factories 라는 파일을 만들어서 등록?해준다.
<img width="439" alt="2018-11-20 1 07 28" src="https://user-images.githubusercontent.com/38067653/48751022-92c69380-ecc5-11e8-9829-627a1ccfe932.png">
<img width="516" alt="2018-11-20 1 07 19" src="https://user-images.githubusercontent.com/38067653/48751035-a245dc80-ecc5-11e8-98e5-2fcb68b218c5.png">
<img width="324" alt="2018-11-20 1 07 54" src="https://user-images.githubusercontent.com/38067653/48751048-affb6200-ecc5-11e8-9215-4caca4af0034.png">

## 덮어쓰기를 방지하기
@ConditionalOnMissingBean 을 붙여주면 그 설정 파일을 사용하는 프로젝트에서 설정을 수정했다면 그 수정 파일이 적용된다.

빈재정의로 수정하지 말고 설정 프로젝트에서 별도의 
Hellotestpropertise 파일 을 생성해서 @ConfigurationProperties 애노테이션을 달고 gettersetter을 달아준다.
application.properties 파일에 hellotest.name , hellotest.age 값 작성으로 빈 재정의 없이도 변경가능해진다.


## 서블릿, 서블릿 컨테이너, 디스페쳐 서블릿, JSP 대한 개념 잡기
http://mangkyu.tistory.com/14 참고!
서블릿 컨테이너 - 톰캣
서블릿 컨테이너는 클라이언트의 요청(Request)을 받아주고 응답(Response)할 수 있게, 웹서버와 소켓을 만들어 통신하며 대표적인 예로 톰캣(Tomcat)이 있습니다.
톰캣은 실제로 웹서버와 통신하여 JSP(자바 서버 페이지)와 Servlet이 작동하는 환경을 제공해줍니다
- dispatcherservlet 이란
http://mangkyu.tistory.com/18 참고!

자동 설정 파일로 내장 웹 서버가 만들어진
- ServletWebServerFactoryAutoConfiguration- 서블릿 웹 서버 생성
- DispatcherServletAutoConfiguration - 서블릿 만들고 서블릿 컨테이너에 등록

이렇게 나눠져 있는 이유는 서블릿 컨테이너는 달라질 수 있는데 서블릿은 그렇지 않기 때문이다.




