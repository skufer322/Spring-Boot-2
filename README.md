# Spring Boot 2

## RunWith vs. ExtendWith
* in JUnit5 wurde das JUnit4 @RunWith mit der mächtigeren Annotation @ExtendWith ersetzt
* mit Spring (**nicht** SpringBoot) -> @RunWith(SpringRunner.class) ersetzen durch @ExtendWith(SpringExtension.class)
* für Mockito: @ExtendWith(MockitoExtension.class)

## Mock vs. MockBean
* @MockBean -> für **Integrationstests**: 
    * The mock will replace any existing bean of the same type in the application context.
    * If no bean of the same type is defined, a new one will be added.
    * MockBeans müssten auch automatisch in die anderen @Components injected werden.
