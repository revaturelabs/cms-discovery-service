package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Content;
import com.revature.entities.ContentModule;
import com.revature.entities.Module;
import com.revature.services.ContentService;
import com.revature.services.ModuleService;

@CrossOrigin(origins = "*", allowCredentials="true")
@RestController
public class ContentController {

	@Autowired
	ContentService contentService;
	
	@Autowired
	ModuleService moduleService;
	
	@RequestMapping(value = "/content", method = RequestMethod.POST) 
	public Content createContent(@RequestParam("newContent") Content content, @RequestParam("modules") String[] moduleNames) {
		Content createdContent = contentService.createContent(content);
		
		
		
		return createdContent;
	}
	
	@RequestMapping(value = "/content", method = RequestMethod.GET)
	public Set<Content> getAllContent() {
		return contentService.getAllContent();
	}
	
	@RequestMapping(value = "/content/{id}", method = RequestMethod.GET)
	public Content getContentById(@PathVariable int id) {
		return contentService.getContentById(id);
	}
	
	@RequestMapping(value = "/content", method = RequestMethod.PUT)
	public Content updateContent(@RequestBody Content inputContent) {
		return contentService.updateContent(inputContent);
	}
	
	@RequestMapping(value = "/content/{id}/modules", method = RequestMethod.PUT)
//	public Content addContentModules(@PathVariable int id, int[] moduleIds) {
	public Content addContentModules(@PathVariable int id, ContentModule[] contentModules) {
		Content existingContent = contentService.getContentById(id);
		List<Module> modulesToAdd = new ArrayList<Module>();

//		for (int moduleId : moduleIds) {
//			modulesToAdd.add(moduleService.getModuleById(moduleId));
//		}
		
		for (ContentModule contentModule : contentModules) {
			modulesToAdd.add(moduleService.getModuleById(contentModule.getFkModule()));
		}
		
		return contentService.addContentModules(existingContent, modulesToAdd.toArray(new Module[0]));
	}
}
