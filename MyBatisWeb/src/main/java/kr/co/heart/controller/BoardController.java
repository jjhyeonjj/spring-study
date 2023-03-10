package kr.co.heart.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.heart.domain.BoardDto;
import kr.co.heart.domain.PageResolver;
import kr.co.heart.domain.SearchItem;
import kr.co.heart.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

   @Autowired
   BoardService boardService;

   @PostMapping("/modify")
   public String modify(BoardDto boardDto, Integer page, Integer pageSize,
                   RedirectAttributes rattr, Model model, HttpSession session) {
      String writer = (String)session.getAttribute("id");
      boardDto.setWriter(writer);
      
      try {
         if (boardService.modify(boardDto) != 1) {
            throw new Exception("Modify failed");
         }
         rattr.addAttribute("page", page);
         rattr.addAttribute("pageSize", pageSize);
         rattr.addFlashAttribute("msg","MOD_OK");
         return "redirect:/board/list";
      } catch (Exception e) {
         e.printStackTrace();
         model.addAttribute(boardDto);
         model.addAttribute("page",page);
         model.addAttribute("pageSize",pageSize);
         model.addAttribute("msg","MOD_ERR");
         return "/board";
      }
   }

   @PostMapping("/write")
   public String write(BoardDto boardDto, RedirectAttributes rattr, Model model, HttpSession session) {
      String writer = (String) session.getAttribute("id");
      boardDto.setWriter(writer);

      try {
         if (boardService.write(boardDto) != 1) {
            throw new Exception("Write failed");
         }
         rattr.addFlashAttribute("msg", "WRT_OK");
         return "redirect:/board/list";
      } catch (Exception e) {
         e.printStackTrace();
         model.addAttribute("mode", "new"); // ????????? ??????
         model.addAttribute("boardDto", boardDto); // ??????????????? ????????? ???????????? ???
         model.addAttribute("msg", "WRT_ERR");
         return "board";
      }
   }

   @GetMapping("/write")
   public String write(Model model) {
      model.addAttribute("mode", "new");

      return "board"; // board.jsp ????????? ????????? ??????. ????????? ????????? ?????? mode=new
   }

   @PostMapping("/remove")
   public String remove(Integer bno, Integer page, Integer pageSize, RedirectAttributes rattr, HttpSession session) {
      System.out.println("???????????? ??????");
      String writer = (String) session.getAttribute("id");
      String msg = "DEL_OK";
      try {
         if (boardService.remove(bno, writer) != 1) {
            throw new Exception("Delete failed.");
         }
      } catch (Exception e) {
         e.printStackTrace();
         msg = "DEL_ERR";
      }

      // ?????? ??? ???????????? ????????? ????????? ???. Model??? ?????? RedirectAttributes??? ???????????? ???????????? ????????? ??????.
      // addFlashAttribute() : ?????? ???????????? ???????????? ??????. ????????? ?????? ??????????????? ?????? ?????? ????????????. ???????????? ????????? ??????.
      rattr.addAttribute("page", page);
      rattr.addAttribute("pageSize", pageSize);
      rattr.addFlashAttribute("msg", msg);

      return "redirect:/board/list";
   }

   @GetMapping("/read")
   public String read(Integer bno, SearchItem sc, Model model) {
      try {
         BoardDto boardDto = boardService.read(bno);
         // model.addAttribute("boardDto", boardDto); //?????? ????????? ??????
         model.addAttribute(boardDto);

      } catch (Exception e) {
         e.printStackTrace();
         return "redirect:/board/list";
      }
      return "board";
   }

   @GetMapping("/list")
   public String list(SearchItem sc, 
         Model model, HttpServletRequest request) {

      if (!loginCheck(request)) {
         return "redirect:/login/login?toURL=" + request.getRequestURL();
      }

      try {
//         if (page==null) {page=1;}
//         if (pagrSize==null) {pagrSize=10;}

         int totalCnt = boardService.getsearchResultCnt(sc);
         model.addAttribute("totalCnt", totalCnt);

         PageResolver pageResolver = new PageResolver(totalCnt, sc);

         List<BoardDto> list = boardService.getSearchResultPage(sc);
         model.addAttribute("list", list);
         model.addAttribute("pr", pageResolver);

      } catch (Exception e) {
         e.printStackTrace();
      }

      return "boardList"; // ????????? ??? ??????, ????????? ?????? ???????????? ??????
   }

   private boolean loginCheck(HttpServletRequest request) {
      // 1. ????????? ?????????
      HttpSession session = request.getSession(false); // false??? session??? ????????? ?????? ???????????? ??????. ????????? null
      // 2. ????????? id??? ????????? ??????, ????????? true??? ??????
      return session != null && session.getAttribute("id") != null;
   }
}