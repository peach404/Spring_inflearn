# Spring의 핵심 기능 설명

IoC 프레임워크 없이 직접 구현할 수 있는 기술이다. 이로인해 테스트 코드 만들기 쉬워졌다. IoC 컨테이너의 핵심 인터페이스는 Application Context 이다. Bean을 만들고 엮어주고 제공해준다. 빈의 중요 설정사항 – 클래스 타입/ 스콥/ 아이디 or ID

# Bean 
스프링 IoC컨테이너가 관리하는 객체로 빈만 의존성 주입을 해준다.

Component Scanning 으로 빈을 등록한다. @Component 에노테이션을 찾아서 빈으로 등록해주는 것이다. 이외에 @Controller, @Service,@Repository 에노테이션 내부속성에도 @Component 가 포함되어있어 컴포넌트 스캔에 사용된다.

직접 @Bean을 등록한다. 단 등록하고 싶은 빈 위에 @configuration이 등록되어 있어야 한다. 이 에노테이션 역시 다른 에노테이션 안에 포함되어 있기도 한다.

Bean 꺼내서 사용하는 방법은 @Autowired 또는 @Inject가 붙이고 쓰거나 Application Context 에서 getBean()으로 직접 꺼내서 사용한다.

@Autowired / @Inject는 어디에 붙일까? 빈이 되는 클래스에 생성자가 오로지 한개이고 그 생성자의 매개변수 타입이 빈으로 등록되어 있으면 @Autowired 붙이는 것을 생략해도 빈을 주입해준다. 이렇게 생성자에 생략된 형태로 붙거나 이조건이 만족되지 않으면 Setter에 붙이고 Setter가 없으면 필드에 붙여준다.

# AOP 
중첩되는 로직의 코드를 한곳에 모아서 코딩하고 그 로직이 필요한 부분마다 어노테이션을 붙여준다. AOP 실행방법으로는 크게 바이트 코드를 조작해서 실행하는 방법과 내부적으로 프록시 패턴을 사용하는 방법이 있는데 스프링에서는 후자의 방법을 이용한다.

예) 원하는 로직을 어디에 적용할지 코딩하는 클래스에 '@Around(“@annotation(NewLogic)”) Public Object newLogic(ProceedingJoinPoint joinPoint)throw Throwable {

}'

애노테이션을 어디에 적용시킬지 표시하는 에노테이션 등록 ' @Target(ElementType.METHOD) @Retention(RetentionPolicy.RUNTIME) public@interface NewLogic{ }'

# PSA 
잘 만든 인터페이스라고 이해하면 된다. 추상화 된 인터페이스 유연하고 확장성 좋은 코드를 작성할 수 있다. 확장성이 좋지 못한 코드 혹은 기술에 특화되어 있는 코드를 그 반대로 고쳐준다. 장점 : 밑단에 있는 코드가 리엑트 이건 서블릿던 내가 작성한 코드를 변경할 필요가 없다. 테스트 코드를 작성하기 쉽다. 스프링 프레임 워크가 제공해주는 대부분의 api는 psa 이다.

예) 스프링 트렌젝션 추상화의 핵심 인터페이스는? @Transcational 은 Platform Transaction Manager를 사용하고 있기 때문에 밑단에서 Mybatis를 쓰던 hibernate를 쓰던 코드를 수정 할 필요 없다.

웹 mvc 에서 요청을 처리하는 메소드에 사용하는 에노테이션은? @GetMapping , @RequestMapping

====================================================================================
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

## 내장 웹서버 HPPTS 설정하기
https://opentutorials.org/course/228/4894 -> 생활코딩 HTTPS SSL 자세한 개념 
SSL을 사용하려면 키스토어를 만들어야한다.
 
 
## 독립적으로 jar파일만 있어도 실행가능
jar 안에 의존성 다 들어있다
org.springframework.boot.loader.jar.JarFile에서 내장jar를 읽고 
org.springframework.boot.loader.Launcher에서 실행한다.





