package kr.co.himedia;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import common.CommonService;

@Controller
public class DataController {
	private String key = "K0ylna0wkk7cU6S2Nq2Qg0Vd%2FN5YwfvKDhPTbrqVM8QA2ntl14%2FH3KJSbC24h6Dtz80YclHKn7reR7n0q3wsRw%3D%3D";//일반인증키(Encoding)
	@Autowired 
	private CommonService common;
	
	@RequestMapping("list.da")
	public String data(HttpSession session) {
		session.setAttribute("category", "da");
		return "data/list";
	}
	
	//약국 정보 조회 요청
	@ResponseBody
	@RequestMapping(value="/data/pharmacy", produces ="application/json; charset=utf-8")
	public String pharmacy_list(int pageNo) {
		StringBuilder url = new StringBuilder("http://apis.data.go.kr/B551182/pharmacyInfoService/getParmacyBasisList");
		url.append("?ServiceKey=" + key);
		url.append("&_type=json"); //parameter가 _type이라 _가 붙음
		url.append("&pageNo=" + pageNo);
		
		//return common.xml_list(url);
		return common.json_list(url);
	}

}
