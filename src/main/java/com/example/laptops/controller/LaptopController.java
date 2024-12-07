package com.example.laptops.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.laptops.model.laptop.CPU;
import com.example.laptops.model.laptop.Dimension_weight;
import com.example.laptops.model.laptop.Graphics_audio;
import com.example.laptops.model.laptop.Laptop;
import com.example.laptops.model.laptop.Laptop_Money;
import com.example.laptops.model.laptop.Other_info;
import com.example.laptops.model.laptop.Ports_features;
import com.example.laptops.model.laptop.Ram_storage;
import com.example.laptops.model.laptop.Screen;
import com.example.laptops.service.LaptopService;
@Controller
public class LaptopController {
	 @Autowired
	  private LaptopService laptopService;

	  @GetMapping("/laptops")
	  public String getAllLaptops(@RequestParam(name = "page", defaultValue = "1") int page, Model model) throws SQLException  {
		  int size = 20; // Số lượng laptop mỗi trang
		  List<Laptop> laptopPT = laptopService.getLaptopsByPage(page, size);
		  for (Laptop d : laptopPT) {
			int price = d.getLaptop_price();
            int million = price / 1000000;
            int thousand = (price % 1000000) / 1000;
            String formattedPrice = million + "," + thousand + ",000₫";  // Định dạng giá trị

            d.setFormattedPrice(formattedPrice); // Lưu giá đã định dạng vào laptop
		  }
		  int totalPages = laptopService.getTotalPages(size);
		  // Đưa dữ liệu phân trang vào model
		  model.addAttribute("laptopPT", laptopPT);
		  model.addAttribute("totalPages", totalPages);
		  model.addAttribute("currentPage", page);
	      return "admin/laptop_list";
	  }
	  @GetMapping("/details/{laptop_id}")
	  public String getDetails_Product(@PathVariable(required = false) Integer laptop_id ,Model model) {
		  Laptop laptop = laptopService.getDetailsLaptopById(laptop_id);
	      model.addAttribute("laptop", laptop);
	      return "admin/detail_products";
	  }
	  @GetMapping({"/admin/addandupdate", "/update/{laptop_id}"})
	  public String addOrUpdateLaptopPage(@PathVariable(required = false) Integer laptop_id, Model model) {
		  System.out.println("Laptop ID: " + laptop_id); // Debugging
	      if (laptop_id == null) {
	    	  model.addAttribute("laptop", new Laptop());
			  model.addAttribute("cpu", new CPU());
	      } else {
			Laptop lt = laptopService.getDetailsLaptopById(laptop_id);
	    	  Laptop laptop = laptopService.getLaptopById(laptop_id);
			  CPU cpu = laptopService.getCPUById(laptop_id);
			  model.addAttribute("lt",lt);
	          model.addAttribute("laptop", laptop);
			  model.addAttribute("cpu", cpu);
	      }
	      return "admin/addandupdate";
	  }
	  @GetMapping("/admin/dashboard")
	  public String showDashboard(@RequestParam(name = "page", defaultValue = "1") int page, Model model) throws SQLException {
		  // Danh sách các thương hiệu laptop
		List<Integer> doanhThu = laptopService.getAllDoanhThu();
		model.addAttribute("doanhThu", doanhThu);
		  // Lấy các thông tin về Laptop_Money
		  List<Laptop_Money> laptopMoney = laptopService.getAllLaptop_Moneys();
		  model.addAttribute("laptopMoney", laptopMoney);
		List<String> allThang = laptopService.getAllThang();
		model.addAttribute("allThang", allThang);
		List<Integer> allSoLuong = laptopService.getAllSoLuong();
		model.addAttribute("allSoLuong", allSoLuong);
		List<Integer> slT1 = laptopService.getAllSoLuongThang(1);
		model.addAttribute("slT1", slT1);
		List<Integer> slT2 = laptopService.getAllSoLuongThang(2);
		model.addAttribute("slT2", slT2);
		List<Integer> slT3 = laptopService.getAllSoLuongThang(3);
		model.addAttribute("slT3", slT3);
		List<Integer> slT4 = laptopService.getAllSoLuongThang(4);
		model.addAttribute("slT4", slT4);
		List<Integer> slT5 = laptopService.getAllSoLuongThang(5);
		model.addAttribute("slT5", slT5);
		List<Integer> slT6 = laptopService.getAllSoLuongThang(6);
		model.addAttribute("slT6", slT6);
		List<Integer> slT7 = laptopService.getAllSoLuongThang(7);
		model.addAttribute("slT7", slT7);
		List<Integer> slT8 = laptopService.getAllSoLuongThang(8);
		model.addAttribute("slT8", slT8);
		List<Integer> slT9 = laptopService.getAllSoLuongThang(9);
		model.addAttribute("slT9", slT9);
		List<Integer> slT10 = laptopService.getAllSoLuongThang(10);
		model.addAttribute("slT10", slT10);
		List<Integer> slT11 = laptopService.getAllSoLuongThang(11);
		model.addAttribute("slT11", slT11);
		List<Integer> slT12 = laptopService.getAllSoLuongThang(12);
		model.addAttribute("slT12", slT12);
		  // Trả về view cho dashboard
		  return "admin/dashboard";
	  }
	  
	/*   @PostMapping("/admin/addandupdate")
	  public String saveNewLaptop(@ModelAttribute Laptop laptop) {
	      if (laptop.getLaptop_id() == null) {
	          laptopService.addLaptop(laptop);
	      }
	      return "redirect:/admin/laptop-list";
	  }*/
	   /*  @PostMapping("/admin/addandupdate")
    public String addLaptop(@ModelAttribute Laptop laptop, 
                            @ModelAttribute CPU cpu, 
                            @ModelAttribute Ram_storage ramStorage, 
                            @ModelAttribute Screen screen, 
                            @ModelAttribute Graphics_audio graphicsAudio,
                            @ModelAttribute Ports_features portsFeatures,
                            @ModelAttribute Dimension_weight dimensionsWeight,
                            @ModelAttribute Other_info otherInfo, 
                            Model model) {

        // Thêm laptop
        int laptopResult = laptopService.addLaptop(laptop);
        
        // Thêm CPU details
        int cpuResult = laptopService.addCpuDetails(cpu);
        
        // Thêm RAM và Storage
        int ramStorageResult = laptopService.addRamStorage(ramStorage);
        
        // Thêm Screen Details
        int screenResult = laptopService.addScreenDetails(screen);
        
        // Thêm Graphics and Audio
        int graphicsAudioResult = laptopService.addGraphicsAudio(graphicsAudio);
        
        // Thêm Ports and Features
        int portsFeaturesResult = laptopService.addPortsFeatures(portsFeatures);
        
        // Thêm Dimensions and Weight
        int dimensionsWeightResult = laptopService.addDimensionsWeight(dimensionsWeight);
        
        // Thêm Other Info
        int otherInfoResult = laptopService.addOtherInfo(otherInfo);
        
        // Kiểm tra kết quả và thông báo cho người dùng
        if (laptopResult > 0 && cpuResult > 0 && ramStorageResult > 0 && 
            screenResult > 0 && graphicsAudioResult > 0 && portsFeaturesResult > 0 &&
            dimensionsWeightResult > 0 && otherInfoResult > 0) {
            model.addAttribute("message", "Laptop và các chi tiết đã được thêm thành công.");
        } else {
            model.addAttribute("message", "Có lỗi xảy ra khi thêm laptop.");
        }

        // Quay lại trang danh sách laptops
        return "redirect:/laptops";
    }*/
	@PostMapping("/admin/addandupdate")
    public String addLaptop(@ModelAttribute Laptop laptop, @ModelAttribute CPU cpuDetails, 
                            @ModelAttribute Ram_storage ramStorage, @ModelAttribute Screen screenDetails,
                            @ModelAttribute Graphics_audio graphicsAudio, @ModelAttribute Ports_features portsFeatures,
                            @ModelAttribute Dimension_weight dimensionsWeight, @ModelAttribute Other_info otherInfo, 
                            Model model) {
        laptopService.addLaptopAndDetails(laptop, cpuDetails, ramStorage, screenDetails, 
                                          graphicsAudio, portsFeatures, dimensionsWeight, otherInfo);
        return "redirect:/laptops"; // Chuyển hướng hoặc trả về trang xác nhận
    }
	  @PutMapping("/admin/update/{laptop_id}")	
	  public String updateLaptop(@PathVariable Integer laptop_id, @ModelAttribute Laptop laptop) {
	      laptopService.updateLaptop(laptop);
	      return "redirect:/laptops";
	  }

	  /*  @DeleteMapping("/delete/{laptop_id}")
	    public String deleteLaptop(@PathVariable Integer laptop_id) {
	        laptopService.deleteLaptop(laptop_id);
	        return "redirect:/admin/laptop_list"; 
	    } */ 
		@DeleteMapping("/laptops/delete/{laptop_id}")
public ResponseEntity<String> deleteLaptop(@PathVariable Integer laptop_id) {
    laptopService.deleteLaptop(laptop_id);  // Thực hiện xóa laptop
    return ResponseEntity.ok("Xóa thành công 12" );  // Trả về thông báo thành công
}

	 /*@GetMapping("/admin/dashboard")
     public String showDashboard() {
        
        return "admin/dashboard";
        }*/
	 @GetMapping("/shared/login")
	    public String showLoginPage() {
	        return"shared/login"; 
	    }
	 @GetMapping("/shared/register")
	    public String showResigterPage() {
	        return"shared/register"; 
	    }
	 @GetMapping("/shared/forgotpassword")
	    public String showForgotPage() {
	        return"shared/forgotpassword"; 
	    }
	 //@Autowired
    //private LaptopService productService;

   
	    
}
