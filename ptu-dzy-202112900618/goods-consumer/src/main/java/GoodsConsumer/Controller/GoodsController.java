package GoodsConsumer.Controller;

import GoodsConsumer.Service.GoodsService;
import model.Cart;
import model.Goods;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GoodsController {
    @Resource
    GoodsService goodsService;
    // 退出登录并跳转回登录页面
    @GetMapping("/quit")
    public String quit(HttpSession session){
        session.removeAttribute("uaccount");
        return "redirect:http://localhost:5000/user/tologin";
    }


    // 首页查询全部商品并分类显示
    @GetMapping(value = "/getAll")
    public String getAll(HttpServletRequest request, String uaccount, String upassword,
                         String uname, String usex, HttpSession session) {
        session.setAttribute("uaccount", uaccount);
        List<Goods> goods1 = new ArrayList<>();
        List<Goods> goods2 = new ArrayList<>();
        List<Goods> goods3 = new ArrayList<>();
        List<Goods> goods4 = new ArrayList<>();
        List<Goods> oldgoods = goodsService.getAllGoods();
        for (Goods newgoods : oldgoods) {
            if (newgoods.getTypes().equals(1)) {
                goods1.add(newgoods);
            } else if (newgoods.getTypes().equals(2)) {
                goods2.add(newgoods);
            } else if (newgoods.getTypes().equals(0)) {
                goods3.add(newgoods);
            } else if (newgoods.getTypes().equals(3)) {
                goods4.add(newgoods);
            }
        }
        request.setAttribute("goods1", goods1);
        request.setAttribute("goods2", goods2);
        request.setAttribute("goods3", goods3);
        request.setAttribute("goods4", goods4);
        return "index";
    }

    // 商品详情 - 根据ID查询单个商品
    @GetMapping(value = "/detail")
    public String detail(HttpServletRequest request, int gid) {
        request.setAttribute("detail", goodsService.getGoodById(gid));
        return "detail";
    }

    // 首页搜索 - 根据名称模糊查找商品
    @GetMapping(value = "/getOne")
    public String getOne(HttpServletRequest request, String name) {
        List<Goods> goods1 = new ArrayList<>();
        List<Goods> goods2 = new ArrayList<>();
        List<Goods> goods3 = new ArrayList<>();
        List<Goods> goods4 = new ArrayList<>();
        List<Goods> oldgoods = goodsService.getGoodsByName(name);

        for (Goods newgoods : oldgoods) {
            System.out.println(newgoods.getTypes());
            if (newgoods.getTypes().equals(1)) {
                goods1.add(newgoods);
            }
            if (newgoods.getTypes().equals(2)) {
                goods2.add(newgoods);
            }
            if (newgoods.getTypes().equals(0)) {
                goods3.add(newgoods);
            }
            if (newgoods.getTypes().equals(3)) {
                goods4.add(newgoods);
            }
        }

        request.setAttribute("goods1", goods1);
        request.setAttribute("goods2", goods2);
        request.setAttribute("goods3", goods3);
        request.setAttribute("goods4", goods4);
        return "index";
    }

    // 加入购物车 - 将商品加入购物车并查询出全部商品如果有商品修理商品数量
    @GetMapping("/cart")
    public String cart(HttpServletRequest request, String name, String price, String che, String number, HttpSession session) {

        String uid = (String) session.getAttribute("uaccount");
        List<Cart> usercart = goodsService.getAllCart(Integer.parseInt(uid));

        int n = Integer.parseInt(price);
        for (int i = 0; i < usercart.size(); i++) {
            if (usercart.get(i).getGoodid() == Integer.parseInt(che)) {
                goodsService.updateCart(Integer.parseInt(number), usercart.get(i).getId());
                return "redirect:http://localhost:5000/goods/cartAll";
            }
        }

        goodsService.insertCart(name, Integer.parseInt(number), n, Integer.parseInt(che), Integer.parseInt(uid));
        return "redirect:http://localhost:5000/goods/cartAll";
    }

    // 查询购物车全部商品
    @GetMapping("/cartAll")
    public String cartAll(HttpServletRequest request, HttpSession session) {
        String uid = (String) session.getAttribute("uaccount");
        request.setAttribute("carts", goodsService.getAllCart(Integer.parseInt(uid)));
        return "Settle";
    }

    // 删除购物车，根据id删除购物车商品
    @GetMapping("/deleteCart")
    public String deleteCart(HttpServletRequest request, String did) {
        goodsService.deleteCart(Integer.parseInt(did));
        return "redirect:http://localhost:5000/goods/cartAll";
    }

    // 添加订单并调用删除购物车功能（即购买之后删除购物车商品）
    @GetMapping("/paygoods")
    public String paygoods(HttpServletRequest request, String[] goodid, String[] numaa, HttpSession session, String[] id) {
        String uid = (String) session.getAttribute("uaccount");

        if (goodid.length == 0 || numaa.length == 0 || id.length == 0) {
            return "redirect:http://localhost:5000/goods/cartAll";
        } else {
            for (int i = 0; i < goodid.length; i++) {
                goodsService.insertOrder(
                        goodsService.getGoodById(Integer.parseInt(goodid[i])).getGname(),
                        Integer.parseInt(numaa[i]),
                        Integer.parseInt(numaa[i]) * goodsService.getGoodById(Integer.parseInt(goodid[i])).getGprice(),
                        Integer.parseInt(uid));
                goodsService.deleteCart(goodsService.deleteCart(Integer.parseInt(id[i])));
            }
            request.setAttribute("mag3", "购买失败");
            return "redirect:http://localhost:5000/goods/getAllorder";
        }
    }
    // 根据用户查询登陆者的购买记录
    @GetMapping("/getAllorder")
    public String getAllorder(HttpServletRequest request, HttpSession session) {
        String uid = (String) session.getAttribute("uaccount");
        request.setAttribute("order", goodsService.getAllOrder(Integer.parseInt(uid)));

        if (uid.equals(null)) {
            return "redirect:http://localhost:5000/user/toLogin";
        }

        return "order";
    }



}
