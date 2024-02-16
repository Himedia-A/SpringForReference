package kr.co.himedia;

import java.io.File;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import common.CommonService;
import member.MemberServiceImpl;
import member.MemberVO;
import notice.NoticePage;
import notice.NoticeServiceImpl;
import notice.NoticeVO;
import qna.QnaPage;
import qna.QnaServiceImpl;
import qna.QnaVO;

@Controller
public class QnAController {
	@Autowired
	private QnaServiceImpl service;
	@Autowired
	private MemberServiceImpl member;
	@Autowired
	private CommonService common;
	@Autowired
	private QnaPage page;
	

	
	 //공지사항 목록 화면 요청/////////////////////////////////////////////////////////
	
	 @RequestMapping("/list.qna")
	 public String list(Model model, HttpSession session, @RequestParam(defaultValue = "1") int curPage, String search, String keyword) {
		 //공지사항 클릭하면  admin으로 자동 로그인
		 HashMap<String, String> map =new HashMap<String,String>();
		 //HashMap : 데이터를 담을 자료 구조
		 map.put("id", "admin");
		 map.put("pw", "1234");
		 session.setAttribute("login_info", member.member_login(map));
		 session.setAttribute("category", "qna");
		 //DB에서 공지 글 목록을 조회해서 목록 화면에 출력
		 page.setCurPage(curPage);
		 page.setSearch(search);
		 page.setKeyword(keyword);
		 model.addAttribute("page",service.qna_list(page));
		 
		 return "qna/list";
	 }
	 
	// 신규 공지 글 작성 화면 요청///////////////////////////////////////////////////////////
	 @RequestMapping("/new.qna")
	 public String qna() {
		 return "qna/new";
	 }
   
    //신규 공지 글 저장 처리 요청//////////////////////////////////////////////////////////////
	 @RequestMapping("/insert.qna")
	 public String insert(MultipartFile file, QnaVO vo, HttpSession session) {
		//첨부한 파일을 서버 시스템에 업로드하는 처리
		 if(!file.isEmpty()) {
			 vo.setFilepath(common.upload("notice",file,session));
			 vo.setFilename(file.getOriginalFilename());
		 }
		 
		  vo.setWriter(((MemberVO) session.getAttribute("login_info")).getId());
		  //화면에 입력한 정보를 db에 저장
          service.qna_insert(vo);
		  //목록화면으로 연결
		  return "redirect:list.qna";
	 }
	 
	 //공지글 상세 화면 요청////////////////////////////////////////////////////////////////////
	 @RequestMapping("/detail.qna")
	 public String detail(int id, Model model) {
		 //선택된 공지글에 대한 조회수 증가 처리
		 service.qna_read(id);
		 //선택한 공지글 정보를 db에서 조회해서 상세 화면에 출력
		 model.addAttribute("vo", service.qna_detail(id));
		 model.addAttribute("crlf","\r\n");
		 model.addAttribute("page",page);
		 
		 return "qna/detail";
	 }
	 
	 //첨부파일 다운로드 요청////////////////////////////////////////////////////////////////////////
	  @ResponseBody
	  @RequestMapping("/download.qna")
	  public void download(int id, HttpSession session, HttpServletResponse response) {
		  QnaVO vo = service.qna_detail(id);
		  common.download(vo.getFilename(),vo.getFilepath(),session ,response);		  
		  } // download()
	 
	 //공지글 삭제 처리 요청/////////////////////////////////////////////////////////////////////////////
	  @RequestMapping("/delete.qna")
	  public String delete(int id, HttpSession session) {
		  //선택한 공지글에 첨부된 파일이 있다면 서버의 물리적 영역에서 해당 파일도 삭제한다
		  QnaVO vo = service.qna_detail(id);
		  if(vo.getFilepath() !=null) {
			  File file = new File(session.getServletContext().getRealPath("resources") + vo.getFilepath());
			  if(file.exists()) {file.delete();}
		  }
		  
		  //선택한 공지글을 DB에서 삭제한 후 목록화면으로 연결
		  service.qna_delete(id);
		  
		  return "redirect:list.qna";
	  } // delete()
	  
	  //공지글 수정 화면 요청//////////////////////////////////////////////////////////////////////
	  @RequestMapping("/modify.qna")
	  public String modify(int id, Model model) {
		  //선택한 공지글 정보를 db에서 조회해서 수정화면에 출력
		  model.addAttribute("vo",service.qna_detail(id));
		  return "qna/modify";
	  }// modify()

       
	  // 공지글 수정 처리 요청 //////////////////////////////////////////////////////////////////
	  
	  @RequestMapping("/update.qna")
	  public String update(QnaVO vo, MultipartFile file, HttpSession session, String attach) {
		  
		  //원래 공지글의 첨부 파일 관련 정보를 조회		  
		 QnaVO notice = service.qna_detail(vo.getId());
		  String uuid = session.getServletContext().getRealPath("resources") + notice.getFilepath();
		  //파일을 첨부한 경우 - 없었는데 첨부/ 있던 파일로 바꿔서 첨부
		  if(!file.isEmpty()) {
			  vo.setFilename(file.getOriginalFilename());
			  vo.setFilepath(common.upload("notice", file, session));
			  
			  //원래 있던 첨부 파일은 서버에서 삭제
			  if(notice.getFilename() != null) {
				  File f = new File(uuid);
				  if(f.exists()) { f.delete();}
			  }
		
		  } else {
			  //원래 있던 첨부 파일이 삭제 되거나, 원래부터 첨부 파일이 없었던 경우
			   
			  if(attach.isEmpty()) {
				  //원래 있떤 첨부 파일은 서버에서 삭제
				  if(notice.getFilename() !=null) {
					  File f = new File(uuid);
					  if (f.exists()) { f.delete();}
				  
			   }
			 }  
			  //원래 있던 첨부 파일을 그대로 사용하는 경우
			 else {
				  vo.setFilename(notice.getFilename());
				  vo.setFilepath(notice.getFilepath());
			  }
		  }
		  
		  //화면에서 변경한 정보를 DB에 저장한 후 상세화면으로 연결
		  service.qna_update(vo);
		  
		  return "redirect:detail.qna?id=" + vo.getId();
			  
			  
		  }//update
	  
	  //공지글 답글 쓰기 화면 요청 ==========================================================
	  @RequestMapping("/reply.qna")
	  public String reply(Model model, int id) {
		  //원글의 정보를 답글쓰기 화면에서 알 수 있도록 한다.
		  model.addAttribute("vo", service.qna_detail(id));
		  
		  return "qna/reply";
	  }//reply()
	  
	  //공지글 신규 답글 저장 처리 요청==========================================================
	  
	  @RequestMapping("/reply_insert.qna")
	  public String reply_insert(QnaVO vo, HttpSession session, MultipartFile file) {
		  if(!file.isEmpty()) {
			  vo.setFilename(file.getOriginalFilename());
			  vo.setFilepath(common.upload("notice", file, session));
			  
		  }
		  vo.setWriter( ((MemberVO)session.getAttribute("login_info")).getId());
		  
		  //화면에서 입력한 정보를 db에 저장한 후 목록 화면으로 연결
		  service.qna_reply_insert(vo);
		  return "redirect:list.qna";
	  } //reply_insert()
	  
}
