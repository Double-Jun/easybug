1.创建Web项目
2.加入jar包
>>1).数据库驱动,c3p0,dbutils,fileupload,logging,beanutils,servlet(eclipse中不带这包)
>>2).spring:aop,aspects,beans,context,context-support,core,expression,
            jdbc,orm,tx,web,webmvc,webmvc-protlet
>>3).mybatis:asm,cglib,javassist,mybatis,log4j,slf4j
>>4).spring和mybatis:mybatis-spring
3.包结构
	跳过接口层 , domain(实体类) dao(数据访问层) service(业务层) controller(web层)
4.配置文件
    web
    log4j
    springmvc
    spring
    mybatis
    jdbc
    
5.功能实现
	1、用户注册（发送邮件）  /
	2、用户登陆  /
	3、添加商品    /
	4、查看商品列表   /
	5、查看商品详细信息 /
	6、添加商品购物车   /
	7、查看购物车   /
	8、修改购物车（修改商品数量、删除购物车商品）/
	9、结算（生成订单）
	10、查看订单（状态）
	11、取消订单
	12、在线支付
	13、查看销售榜单（每件商品销售多少件）
	14、榜单导出