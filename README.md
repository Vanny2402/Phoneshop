This is readme
Today is Monday
Read me from Eclipse


ng serve :To Start angular
ng g s service/brnd : To create package service and brnad.service on it 

Week8: 
	-Add model Entity
		-CRUD :EnityModel 
			1.Repository : new Interface ModelRepository -> Extend Jpa repository
			2.Service : new Interface ModelService
			3.Service impl: new class ModelServiceIml -> Implement ModelService
				-Annotation @Service 
				-Call ModelRepository (private ModelRepository modelRepository;)
			4.Controller : new class ModelController
				-Annotation :@RestController
				-Annotation :@RequestMapping("/models")
				-Mapping method:@RequestMapping( method = RequestMethod.POST)//PostMapping
				-@RequestBody ModelDTO modelDTO --> meant: Insert to db follow Template DTO
				-Initiate Model service --> meant controller assign service to insert DB 
					->	private final ModelService modelService;
				-@Autowired : In order to find bean which the implementation of this method
				@RequiredArgsConstructor: To catch all field to pass in the Constructor 
			5.ModelDTO : new class ModelDTO 
				-Add DTO member (id,name..)
				-Convert from modelDTO to ModelEntity In Order to insert 
			6.ModelMapper: new Interface ModelMapper(@Mapper)
				-We create this to map data which is need to inert to db as the Entity type 
				as object (BrandId) --> So we need to convert it Using map Struct
				-@Mapper : Auto Load new Class iml on the Mapper generation 
			7.Note:
				-When we call service at Mapper we should Autowire at In the controller
Week9: swagger 
	1.Add Dependency Swagger 
	2.Add Configuration property 
	3.-->Implement Get model by branch 
		-Request mapping on ModelController (GetmodelsByBrand)
		-Define Repository On ModelRepsitory()
		-Implement Model Service 
			-Create function List<Model> getByBrandId(Integer id);
		-Implement ModelserviceIml
			-Implement function from ModelService 
		-BrandController :
Week8: Liquibase 
	1.To know if someone Update or anything on database 
	2.Configuration
		-Add Dependency
		-Liquibase change Log: liquibase.change-log=classpath:liquibase-changeLog.xml
Week11:Product 
	1.Product 
		-id
		-aviablable_unit 
		-image_path 
		-sale_price
		-color_id
		-name(Iphone14 pro max red)
		-model_id
	2.Color
		-id
		-name
	3.product_import_history
		-id
		-date_import
		-import_unit
		-price_per_unit(priceIn)
		-product_id 
	4.sale
		-id
		-sale_date
	5.sale_detail
		-id
		-sale_id
		-product_id
		-amount
		-unit
		-total amount
Week11:Import product:
	1.productId
	2.importUnit 
	3.importPrice(PriceIn)
	4.importDate
-ProductImportDTO
-ProductService 
-ProductServiceiml
-ProductHistoryRepository 
--> Add javax.validation
--> Add <dependency>
    <groupId>org.hibernate.validator</groupId>
    <artifactId>hibernate-validator</artifactId>
</dependency>

