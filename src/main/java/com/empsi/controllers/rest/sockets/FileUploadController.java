package com.empsi.controllers.rest.sockets;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Hashtable;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
public class FileUploadController {

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ResponseEntity<Hashtable<String, String>> handleFileUpload(@RequestParam("file") MultipartFile file,@RequestParam String name) {
		Hashtable<String, String> resp = new Hashtable<String, String>();
		String uploadPath = "src/main/webapp/resources/img/archive/";

//		String hash = UUID.randomUUID().toString();
//		String extention = file.getOriginalFilename().split("\\.")[1];
//		String name = hash +"."+extention;//UUID.randomUUID()
		String extention = ".png";
		System.out.println("file name :" + name + "and the extansion is " + extention);
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(uploadPath +name+extention)));
				stream.write(bytes);
				stream.close();
				resp.put("name", name);
				System.out.println("You successfully uploaded " +name);
				return new ResponseEntity<Hashtable<String, String>>(resp, HttpStatus.OK);
			} catch (Exception e) {
				System.out.println("You failed to upload"+e.getMessage());
				return new ResponseEntity<Hashtable<String, String>>(HttpStatus.NOT_FOUND);
			}
		} else {
			System.out.println("You failed to upload because file is empty");
			return new ResponseEntity<Hashtable<String, String>>(HttpStatus.NOT_FOUND);
		}
	}

}
