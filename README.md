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
		
			
			
