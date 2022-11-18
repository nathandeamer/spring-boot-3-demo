# Spring Boot 3.0.0-RC2
https://docs.spring.io/spring-boot/docs/3.0.0-RC2/reference/htmlsingle/

## Pre-requisites
Depending on how you would like to build and run you will need either:
- GraalVM (https://bell-sw.com/pages/downloads/native-image-kit/#/nik-22-17)
- Docker (https://rancherdesktop.io/)

## How to build and run (GraalVM)
`./gradlew nativeRun`  
or`./gradlew nativeCompile` and then run the executable `./build/native/nativeCompile/demo`   

## How to build and run (Docker)
`./gradlew bootBuildImage`  
`docker run --rm -p 8080:8080 -p 8081:8081 docker.io/library/demo:0.0.1-SNAPSHOT `

## Compatibility

| Library   	            | Version   	| Compatible  	| Notes   	
|---	                    |---	        |---	        |---		
| Open Feign                |4.0.0-RC1  	| ❌  	        |https://github.com/spring-cloud/spring-cloud-openfeign/issues/742
| Spring Webflux   	        |6.0.0-RC2   	| ✅	        |
| ECS Logging               |1.5.0          | ✅            |
| Spring Docs               |2.0.0-RC1      | ✅            | https://github.com/springdoc/springdoc-openapi/issues/1284#issuecomment-1023445755 <p/> https://github.com/springdoc/springdoc-openapi-demos/tree/2.x/demo-spring-boot-3-webmvc
| Micrometer - Prometheus   |1.10.0-RC1     | ✅            |
| Micrometer - Tracing      |               | ❓            |
| Spring Data               |               | ❓            |
| Spring Kafka              |               | ❓            |

