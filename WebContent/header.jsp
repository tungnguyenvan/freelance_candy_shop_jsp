<%@page import="model.ProduceModel"%>
<%@page import="controller.ProduceController"%>
<%@page import="utils.Constract"%>
<%@page import="controller.CartController"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.CartModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%
	int total = 0;
	ProduceController mProduceController = new ProduceController();
	CartController mCartController = new CartController();
	List<CartModel> carts = new ArrayList();
	if	(Constract.MYMODEL != null){
		carts = mCartController.index(Constract.MYMODEL.getId());
	}
%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<header class="header2">
		<!-- Header desktop -->
		<div class="container-menu-header-v2 p-t-26">
			<div class="topbar2">
				<div class="topbar-social">
					<a href="#" class="topbar-social-item fa fa-facebook"></a>
					<a href="#" class="topbar-social-item fa fa-instagram"></a>
					<a href="#" class="topbar-social-item fa fa-pinterest-p"></a>
					<a href="#" class="topbar-social-item fa fa-snapchat-ghost"></a>
					<a href="#" class="topbar-social-item fa fa-youtube-play"></a>
				</div>

				<!-- Logo2 -->
				<a href="index.jsp" class="logo2">
					<img src="images/icons/logo.png" alt="IMG-LOGO">
				</a>

				<div class="topbar-child2">
					
						<%
						if(Constract.MYMODEL != null){
							%>
							<span class="topbar-email">
							<%=Constract.MYMODEL.getName() %>
							</span>
							<%
							
						}
						%>
					
					<!--  -->
					<a href="login.jsp" class="header-wrapicon1 dis-block m-l-30">
						<img src="images/icons/icon-header-01.png" class="header-icon1" alt="ICON">
					</a>

					<span class="linedivide1"></span>

					<div class="header-wrapicon2 m-r-13">
						<img src="images/icons/icon-header-02.png" class="header-icon1 js-show-header-dropdown" alt="ICON">
						<span class="header-icons-noti"><%=carts.size() %></span>

						<!-- Header cart noti -->
						<div class="header-cart header-dropdown">
							<ul class="header-cart-wrapitem">
							
							<%
								for (int i = 0; i < carts.size(); i++){
									ProduceModel model = mProduceController.get(carts.get(i).getIdProduce());
									total += model.getPrice();
									%>
									
									<li class="header-cart-item">
									<div class="header-cart-item-img">
										<img src="images/<%=model.getImage() %>" alt="IMG">
									</div>

									<div class="header-cart-item-txt">
										<a href="#" class="header-cart-item-name">
											<%=model.getName() %>
										</a>

										<span class="header-cart-item-info">
											<%=model.getPrice() %>
										</span>
									</div>
								</li>
									
									<%
								}
							%>

							<div class="header-cart-total">
								VND <%=total %>
							</div>

							<div class="header-cart-buttons">
								<div class="header-cart-wrapbtn">
									<!-- Button -->
									<a href="cart.jsp" class="flex-c-m size1 bg1 bo-rad-20 hov1 s-text1 trans-0-4">
										View Cart
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="wrap_header">

				<!-- Header Icon -->
				<div class="header-icons">

				</div>
			</div>
		</div>
	</header>
</body>
</html>