package com.spring.test;



import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.test.test1.SHA256Util;
import com.spring.test.test1.AES256Util;
import com.spring.test.test2.PBEWithMD5AndDESUtil;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	//메인 페이지
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String main() {
		return "home";
	}
	
	
	//로그인 페이지
	@RequestMapping(value = "/test1")
	public String test1(){
		log.info("로그인 페이지 진입");
		return "test1";
	}
	
	//로그인
	@RequestMapping(value = "/login")
	public String login(@RequestParam("id") String id, @RequestParam("password") String password,Model model,HttpSession session)
			throws Exception{
		
		
		log.info("로그인"); 
		
		System.out.println("입력받은 id : " + id);
		System.out.println("입력받은 password : " + password);

		if(!AES256Util.encrypt(id).equals(AES256Util.encrypt("testid"))) {
			log.info("로그인 실패(아이디 틀림)");
			model.addAttribute("msg","존재하지 않은 아이디입니다. 다시 시도해주세요");
			model.addAttribute("url","/test1");
			return "redirect";
			
		} else if (!AES256Util.encrypt(password).equals(AES256Util.encrypt("testpw94!"))) {
			log.info("로그인 실패(패스워드 틀림) ");
			model.addAttribute("msg","비밀번호가 틀렸습니다. 다시 시도해주세요");
			model.addAttribute("url","/test1");
			return "redirect";
			
		} else {
			log.info("로그인 성공");
			id = AES256Util.encrypt(id);
			password = AES256Util.encrypt(password);
			
			System.out.println("AES256 암호화 id : " + AES256Util.encrypt(id) +"\n AES256 암호화 pw: " + AES256Util.encrypt(password));
			System.out.println("AES256 복호화 id : " + AES256Util.decrypt(id) +"\n AES256 복호화 pw: " + AES256Util.decrypt(password));
			
			password = SHA256Util.encryptSHA256(password); // aes256 password -> sha256 변환
			System.out.println("AES256 -> SHA256 암호화 pw = " + password);
			
			session.setAttribute("id",id);
			session.setAttribute("password",password);
		}
		return "login_ok";
	}
	
	
	//암호화 변환 페이지
	@RequestMapping(value = "/test2")
	public String test2(){
		log.info("암호화 페이지 진입");
		return "test2";
	}
	
	//암호화
	@RequestMapping(value = "/encrypt")
	public String encrypt(@RequestParam("key") String key,Model model) throws Exception{
		
		try {
			String encrypt = PBEWithMD5AndDESUtil.encStr(key);
			model.addAttribute("key", key);
			model.addAttribute("encrypt", encrypt);
			log.info("암호화 성공 ==> key값: " + key +"\n 암호화된 key 값: " + encrypt );

		} catch (Exception e) {
			model.addAttribute("msg","key값을 정확히 입력해주세요.");
			model.addAttribute("url","/test2");
			log.info("암호화 실패");
			log.debug(PBEWithMD5AndDESUtil.encStr(key));
			return "redirect";
		}
		
		return "encrypt";
	}
	
	//복호화
	@RequestMapping(value = "/decrypt")
	public String decrypt(@RequestParam("key")String encStr,String key,Model model)throws Exception{
		try {
			String decrypt = PBEWithMD5AndDESUtil.decStr(encStr);
			log.info("복호화 성공 ==> key값: " + key +"\n 복호화된 key 값: " + encStr );
			model.addAttribute("key", key);
			model.addAttribute("decrypt", decrypt);
			
		} catch (Exception e) {
			log.info("복호화 실패");
			model.addAttribute("msg","암호화된 key값을 정확히 입력해주세요.");
			model.addAttribute("url","/test2");
			return "redirect";
		}
		
		return "decrypt";
	}
	
}
