package com.jz.community.controller;

import com.jz.community.dto.AccessTokenDTO;
import com.jz.community.dto.GithubUser;
import com.jz.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;
    @Value("${github.client_id}")
    private String clientId;
    @Value("${github.client_secret}")
    private String client_secret;
    @Value("${github.redirect_uri}")
    private String redirect_uri;
    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code")String code, @RequestParam(name="state")String state, HttpServletRequest request){

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(client_secret);
        accessTokenDTO.setRedirect_uri(redirect_uri);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        System.out.println(accessToken);
        GithubUser user = githubProvider.getUser(accessToken);
        if(user!=null){
            request.getSession().setAttribute("user",user);
            return "redirect:/";
        }else{
            return "redirect:/";
        }
    }
}
