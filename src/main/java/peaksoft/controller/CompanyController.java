package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Company;
import peaksoft.service.CompanyService;

@Controller
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping
    public String getAllCompanies(Model model) {
        model.addAttribute("allCompanies", companyService.getAllCompanies());
        return "/companies";
    }

    @GetMapping("/new")
    public String createCompany(Model model) {
        Company company = new Company();
        model.addAttribute("newCompany", company);
        return "/newCompany";
    }

    @PostMapping("/save")
    public String saveCompany(@ModelAttribute("newCompany") Company company) {
        companyService.saveCompany(company);
        return "redirect:/companies";
    }

    @GetMapping("/find/{companyId}")
    public String getById(Model model,@PathVariable("companyId")Long id){
        Company company = companyService.findById(id);
        model.addAttribute("companyInfo",company.getCourses());
        return "/companyInnerPage";
    }

    @DeleteMapping("/{companyId}/delete")
    public String deleteCompanyById(@PathVariable Long companyId) {
        companyService.deleteById(companyId);
        return "redirect:/companies";
    }
}

//    @GetMapping("/edit/{id}")
//    public String editCompany(Model model, @PathVariable("id")Long id){
//        Company company = companyService.findById(id);
//        model.addAttribute("company",company);
//        return "companies/updateCompany";
//    }

//    @PostMapping("/update/{id}")
//    public String updateCompany(@PathVariable("id")Long id,@ModelAttribute("company")Company company){
//        companyService.updateCompany(id, company);
//        return "redirect:/allCompanies";
//    }
//
//
