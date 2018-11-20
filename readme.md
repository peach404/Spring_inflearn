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



