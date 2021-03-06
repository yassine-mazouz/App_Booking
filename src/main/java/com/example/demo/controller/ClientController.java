package com.example.demo.controller;
import com.example.demo.dao.PermissionRepo;
import com.example.demo.dao.ClientRepo;
import com.example.demo.dao.UserRepository;
import com.example.demo.models.Client;
import com.example.demo.models.Permission;
import com.example.demo.services.ClientService;
import com.example.demo.services.UsersService;
import com.example.demo.utility.FileUploadUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("/admin")
public class ClientController {


    @Value("${demo.url}")
    private String baseUrl;

    @Autowired
    private ClientService clientServices;
    @Autowired
    private UsersService userService;
    @Autowired
    private ClientRepo clientRepo;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PermissionRepo permissionRepo;
   @RequestMapping("/clients")
    public ModelAndView welcome() {
        Map<String, Object> model = new HashMap<String, Object>();
        List<Client> clients = clientRepo.findAll();


        model.put("All",clients);
       Permission permission = permissionRepo.findByPageId(1);



       model.put("permission",permission);
       if(!permission.getAfficher().equals("1")){
           return new ModelAndView("/error", model);
       }else {
           return new ModelAndView("/admin/clients", model);
       }
    }
    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String add(@ModelAttribute Client client, @RequestParam("imageFile") MultipartFile imageFile) throws IOException {



        String fileName = StringUtils.cleanPath(imageFile.getOriginalFilename());

        if(!fileName.equals("")){
            client.setImage(fileName);
        }else{
            client.setImage(client.getImage());
        }


        Client saveClient = clientRepo.save(client);

        try {
            String uploadDir = "client-photos/" + saveClient.getId();
            FileUploadUtil.saveFile(uploadDir, fileName, imageFile);
        }catch (Exception e){


        }



        Permission permission = permissionRepo.findByPageId(1);
        if(!permission.getAjouter().equals("1")){
            return "error";
        }else {
            return "redirect:/admin/clients";
        }
    }
    @RequestMapping(value="/getOneClient", method = RequestMethod.GET)
    public @ResponseBody Client getOneClient(@RequestParam int id) throws
            JsonProcessingException {
        Client client = clientServices.GetOneClient(id);


        return client;
    }
    @RequestMapping(value="/deleteClient",method = RequestMethod.GET)
    public String deleteClient(HttpServletRequest id)
    {
        String idd = id.getParameter("id");
        int idint=0;
        if(idd != null && idd !="")
        {
            idint = Integer.parseInt(idd);
            clientServices.deleteClient(idint);
        }
        Permission permission = permissionRepo.findByPageId(1);
        if(!permission.getSupprimer().equals("1")){
            return "error";
        }else {
            return "redirect:/admin/clients";
        }
    }
}