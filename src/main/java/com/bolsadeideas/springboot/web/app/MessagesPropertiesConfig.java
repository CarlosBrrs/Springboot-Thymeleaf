package com.bolsadeideas.springboot.web.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
	@PropertySource("classpath:messages.properties")
})
public class MessagesPropertiesConfig {
	
	//Esta clase sirve para configuarar diferentes .properties, en este caso el messages.properties
	//Esta clase debe ser anotada con @Configuration y @PropertySources
	//El classpath es justamente src/main/resources
	//Se pueden tener varios PropertySource separados por (,)

}
