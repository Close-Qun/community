package life.majiang.community.HelloController;

import life.majiang.community.dto.AccessTokenDto;
import life.majiang.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 陈亦铖
 */
@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @Value("${Client_id}")

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code, @RequestParam(name = "state") String state) {

        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setClient_id("57684b0b34d78ed54f74");
        accessTokenDto.setClient_secret("56083256f6a43e2cf66c88172fb59a46498e0d77");
        accessTokenDto.setCode(code);
        accessTokenDto.setState(state);
        accessTokenDto.setRedirect_uri("http://localhost/callback");

        githubProvider.getAccessToken(accessTokenDto);
        return "index";
    }
}
