# TGproject_flagadmin
场地预约后台

> 临时域名： http://flagadmin.zhengsj.top
一级(Nginx)端口：  8080 (代理静态网页
二级(Tomcat)端口: 8005

```
.
├── flagadmin.iml
├── pom.xml
├── README.md
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── ctg
    │   │           └── flagadmin
    │   │               ├── config
    │   │               │   └── InterceptorWebConfigurer.java
    │   │               ├── dao
    │   │               │   ├── AdminDao.java
    │   │               │   ├── CouncilDao.java
    │   │               │   ├── CouncilOrderDao.java
    │   │               │   ├── MessageDao.java
    │   │               │   ├── PlaceDao.java
    │   │               │   ├── PlaceOrderDao.java
    │   │               │   ├── SpaceApplyDao.java
    │   │               │   └── UserDao.java
    │   │               ├── enums
    │   │               │   ├── AdminKindEnum.java
    │   │               │   ├── CouncilStateEnum.java
    │   │               │   ├── DepartmentKindEnum.java
    │   │               │   ├── MessageKindEnum.java
    │   │               │   ├── MessageStateEnum.java
    │   │               │   ├── PlaceKindEnum.java
    │   │               │   ├── PlaceOrderStateEnum.java
    │   │               │   ├── ResponseStatusEnum.java
    │   │               │   ├── SpaceApplyStateEnum.java
    │   │               │   └── UserInfoStateEnum.java
    │   │               ├── exception
    │   │               │   ├── handler
    │   │               │   │   ├── AuthorityExceptionHandler.java
    │   │               │   │   └── AuthorizationExceptionHandler.java
    │   │               │   ├── NoAuthorityException.java
    │   │               │   └── NoJWTException.java
    │   │               ├── FlagadminApplication.java
    │   │               ├── pojo
    │   │               │   ├── dto
    │   │               │   │   ├── CouncilOrderDetailDto.java
    │   │               │   │   ├── CouncilOrderListDtoComponent
    │   │               │   │   │   ├── ListCompletedTimeDto.java
    │   │               │   │   │   └── ListOrderItemDto.java
    │   │               │   │   ├── CouncilOrderListDto.java
    │   │               │   │   ├── OptionDto.java
    │   │               │   │   ├── OrderManageDto.java
    │   │               │   │   ├── PlaceDetailDto.java
    │   │               │   │   ├── PlaceDto.java
    │   │               │   │   ├── PlaceOrderDetailDto.java
    │   │               │   │   ├── PlaceOrderListItemDto.java
    │   │               │   │   ├── ResponseDto.java
    │   │               │   │   ├── SpaceApplyListItemDto.java
    │   │               │   │   ├── SpaceApplyResponseDto.java
    │   │               │   │   └── TimeSlotDto.java
    │   │               │   └── entity
    │   │               │       ├── Admin.java
    │   │               │       ├── CouncilOrder.java
    │   │               │       ├── Department.java
    │   │               │       ├── Message.java
    │   │               │       ├── Place.java
    │   │               │       ├── PlaceOrder.java
    │   │               │       ├── SpaceApply.java
    │   │               │       └── User.java
    │   │               ├── service
    │   │               │   ├── AdminService.java
    │   │               │   ├── CouncilOrderService.java
    │   │               │   ├── CouncilService.java
    │   │               │   ├── DepartmentService.java
    │   │               │   ├── Impl
    │   │               │   │   ├── AdminServiceImpl.java
    │   │               │   │   ├── CouncilOrderServiceImpl.java
    │   │               │   │   ├── CouncilServiceImpl.java
    │   │               │   │   ├── DepartmentServiceImpl.java
    │   │               │   │   ├── MessageServiceImpl.java
    │   │               │   │   ├── PlaceOrderServiceImpl.java
    │   │               │   │   ├── PlaceServiceImpl.java
    │   │               │   │   └── SpaceApplyServiceImpl.java
    │   │               │   ├── MessageService.java
    │   │               │   ├── PlaceOrderService.java
    │   │               │   ├── PlaceService.java
    │   │               │   └── SpaceApplyService.java
    │   │               ├── utils
    │   │               │   ├── JsonUtil.java
    │   │               │   └── JWTUtil.java
    │   │               └── web
    │   │                   ├── controller
    │   │                   │   ├── AdminController.java
    │   │                   │   ├── CouncilOrderController.java
    │   │                   │   ├── DepartmentController.java
    │   │                   │   ├── MessageController.java
    │   │                   │   ├── PlaceController.java
    │   │                   │   ├── PlaceOrderController.java
    │   │                   │   └── SpaceApplyController.java
    │   │                   ├── filter
    │   │                   │   └── CorsFilter.java
    │   │                   └── interceptor
    │   │                       ├── AuthenticationInterceptor.java
    │   │                       ├── CouncilAuthorityInterceptor.java
    │   │                       ├── PostMessageInterceptor.java
    │   │                       └── SpaceApplyAuthorityInterceptor.java
    │   └── resources
    │       ├── application.yml
    │       ├── import.sql
    │       ├── META-INF
    │       │   └── additional-spring-configuration-metadata.json
    │       └── static
    │           ├── checked.html
    │           ├── council_detail.html
    │           ├── councilpendingdetail.html
    │           ├── css
    │           │   ├── checked.css
    │           │   ├── council_detail.css
    │           │   ├── councilpendingdetail.css
    │           │   ├── login.css
    │           │   ├── star_comein_pend.css
    │           │   ├── star_index.css
    │           │   ├── star_pending.css
    │           │   ├── star_pending_detail.css
    │           │   └── star_space_index.css
    │           ├── index.html
    │           ├── js
    │           │   ├── checked.js
    │           │   ├── council_detail.js
    │           │   ├── councilpendingdetail.js
    │           │   ├── login.js
    │           │   ├── star_index.js
    │           │   ├── star_pending_detail.js
    │           │   └── star_pending.js
    │           ├── login.html
    │           ├── star_index.html
    │           ├── star_pending_detail.html
    │           ├── star_pending.html
    │           ├── test.html
    │           └── utils
    │               ├── bootstrap.css
    │               ├── bootstrap.js
    │               └── jquery.js
    └── test
        └── java
            └── com
                └── ctg
                    └── flagadmin
                        └── FlagadminApplicationTests.java

33 directories, 111 files
```