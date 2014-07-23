package org.wfp.fittest.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.data.rest.webmvc.RepositoryRestDispatcherServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.wfp.fittest.filter.SimpleCORSFilter;

public class WebInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		servletContext.setInitParameter("spring.profiles.active",
				"spring-data-jpa");

		WebApplicationContext rootContext = getRootContext();
		servletContext.addListener(new ContextLoaderListener(rootContext));

		ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
				"fittesttracker", new DispatcherServlet(rootContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");

		ServletRegistration.Dynamic restDispatcher = servletContext.addServlet(
				"rest", new RepositoryRestDispatcherServlet(
						rootContext));
		restDispatcher.setLoadOnStartup(2);
		restDispatcher.addMapping("/rest/*");

		// AnnotationConfigWebApplicationContext mvcServletContext = new
		// AnnotationConfigWebApplicationContext();
		// mvcServletContext.register(ServletConfig.class);
		// mvcServletContext.setParent(rootContext);
		// ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
		// "fittesttracker", new DispatcherServlet(mvcServletContext));
		// dispatcher.setLoadOnStartup(1);
		// dispatcher.addMapping("/");
		//
		// AnnotationConfigWebApplicationContext restServletContext = new
		// AnnotationConfigWebApplicationContext();
		// restServletContext.register(RestConfig.class);
		// restServletContext.setParent(rootContext);
		// ServletRegistration.Dynamic restDispatcher =
		// servletContext.addServlet(
		// "restExporter", new RepositoryRestDispatcherServlet(
		// restServletContext));
		// restDispatcher.setLoadOnStartup(1);
		// restDispatcher.addMapping("/rest/*");

//		FilterRegistration.Dynamic httpFilter = servletContext.addFilter(
//				"httpMethodFilter", new HiddenHttpMethodFilter());
//		httpFilter.addMappingForServletNames(null, true, "fittesttracker");

		FilterRegistration.Dynamic corsFilter = servletContext.addFilter(
				"cors", new SimpleCORSFilter());
		corsFilter.addMappingForUrlPatterns(null, true, "/*");
	}

	private AnnotationConfigWebApplicationContext getRootContext() {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.setDisplayName("FITTEST Tracker");
		rootContext.setConfigLocation("org.wfp.fittest.config");
		return rootContext;
	}
}