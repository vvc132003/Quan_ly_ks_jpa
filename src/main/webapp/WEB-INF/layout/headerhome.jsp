<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!--======== SEARCH-OVERLAY =========-->
<div class="overlay">
	<a href="javascript:void(0)" id="close-button" class="closebtn">&times;</a>
	<div class="overlay-content">
		<div class="form-center">
			<form>
				<div class="form-group">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search..."
							required /> <span class="input-group-btn"><button
								type="submit" class="btn">
								<span><i class="fa fa-search"></i></span>
							</button></span>
					</div>
					<!-- end input-group -->
				</div>
				<!-- end form-group -->
			</form>
		</div>
		<!-- end form-center -->
	</div>
	<!-- end overlay-content -->
</div>
<!-- end overlay -->
<!--============= TOP-BAR ===========-->
        <div id="top-bar" class="tb-text-white">
            <div class="container">
                <div class="row">          
                    <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
                        <div id="info">
                            <ul class="list-unstyled list-inline">
                                <li><span><i class="fa fa-map-marker"></i></span>29 Land St, Lorem City, CA</li>
                                <li><span><i class="fa fa-phone"></i></span>+00 123 4567</li>
                            </ul>
                        </div><!-- end info -->
                    </div><!-- end columns -->
                    
                    <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
                        <div id="links">
                            <ul class="list-unstyled list-inline">
                                <li><a href="login.html"><span><i class="fa fa-lock"></i></span>Login</a></li>
                                <li><a href="registration.html"><span><i class="fa fa-plus"></i></span>Sign Up</a></li>
                                <li>
                                	<form>
                                    	<ul class="list-inline">
                                        	<li>
                                                <div class="form-group currency">
                                                    <span><i class="fa fa-angle-down"></i></span>
                                                    <select class="form-control">
                                                        <option value="">$</option>
                                                        <option value="">£</option>
                                                    </select>
                                                </div><!-- end form-group -->
											</li>
                                            
                                            <li>
                                                <div class="form-group language">
                                                    <span><i class="fa fa-angle-down"></i></span>
                                                    <select class="form-control">
                                                        <option value="">EN</option>
                                                        <option value="">UR</option>
                                                        <option value="">FR</option>
                                                        <option value="">IT</option>
                                                    </select>
                                                </div><!-- end form-group -->
                                            </li>
										</ul>
                                    </form>
                                </li>
                            </ul>
                        </div><!-- end links -->
                    </div><!-- end columns -->				
                </div><!-- end row -->
            </div><!-- end container -->
        </div><!-- end top-bar -->
		
        <nav class="navbar navbar-default main-navbar navbar-custom navbar-white" id="mynavbar-1">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" id="menu-button">
                      <span class="icon-bar"></span>
                      <span class="icon-bar"></span>
                      <span class="icon-bar"></span>                        
                    </button>
                    <div class="header-search hidden-lg">
                    	<a href="javascript:void(0)" class="search-button"><span><i class="fa fa-search"></i></span></a>
                    </div>
                    <a href="#" class="navbar-brand"><span><i class="fa fa-plane"></i>STAR</span>TRAVELS</a>
                </div><!-- end navbar-header -->
                
                <div class="collapse navbar-collapse" id="myNavbar1">
                    <ul class="nav navbar-nav navbar-right navbar-search-link">
                        <li class="dropdown active"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Home<span><i class="fa fa-angle-down"></i></span></a>
                            <ul class="dropdown-menu">
                                <li class="active"><a href="#">Main Homepage</a></li>
                                <li><a href="flight-homepage.html">Flight Homepage</a></li>
                                <li><a href="hotel-homepage.html">Hotel Homepage</a></li>
                                <li><a href="tour-homepage.html">Tour Homepage</a></li>
                                <li><a href="cruise-homepage.html">Cruise Homepage</a></li>
                                <li><a href="car-homepage.html">Car Homepage</a></li>
                                <li><a href="landing-page.html">Landing Page</a></li>
                            </ul>			
                        </li>
                        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Flights<span><i class="fa fa-angle-down"></i></span></a>
                            <ul class="dropdown-menu">
                            	<li><a href="flight-homepage.html">Flight Homepage</a></li>
                                <li><a href="flight-listing-left-sidebar.html">List View Left Sidebar</a></li>
                                <li><a href="flight-listing-right-sidebar.html">List View Right Sidebar</a></li>
                                <li><a href="flight-grid-left-sidebar.html">Grid View Left Sidebar</a></li>
                                <li><a href="flight-grid-right-sidebar.html">Grid View Right Sidebar</a></li>
                                <li><a href="flight-detail-left-sidebar.html">Detail Left Sidebar</a></li>
                                <li><a href="flight-detail-right-sidebar.html">Detail Right Sidebar</a></li>
                            </ul>			
                        </li>
                        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Hotels<span><i class="fa fa-angle-down"></i></span></a>
                            <ul class="dropdown-menu">
                            	<li><a href="hotel-homepage.html">Hotel Homepage</a></li>
                                <li><a href="hotel-listing-left-sidebar.html">List View Left Sidebar</a></li>
                                <li><a href="hotel-listing-right-sidebar.html">List View Right Sidebar</a></li>
                                <li><a href="hotel-grid-left-sidebar.html">Grid View Left Sidebar</a></li>
                                <li><a href="hotel-grid-right-sidebar.html">Grid View Right Sidebar</a></li>
                                <li><a href="hotel-detail-left-sidebar.html">Detail Left Sidebar</a></li>
                                <li><a href="hotel-detail-right-sidebar.html">Detail Right Sidebar</a></li>
                            </ul>			
                        </li>
                        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Tours<span><i class="fa fa-angle-down"></i></span></a>
                            <ul class="dropdown-menu">
                            	<li><a href="tour-homepage.html">Tour Homepage</a></li>
                                <li><a href="tour-listing-left-sidebar.html">List View Left Sidebar</a></li>
                                <li><a href="tour-listing-right-sidebar.html">List View Right Sidebar</a></li>
                                <li><a href="tour-grid-left-sidebar.html">Grid View Left Sidebar</a></li>
                                <li><a href="tour-grid-right-sidebar.html">Grid View Right Sidebar</a></li>
                                <li><a href="tour-detail-left-sidebar.html">Detail Left Sidebar</a></li>
                                <li><a href="tour-detail-right-sidebar.html">Detail Right Sidebar</a></li>
                            </ul>			
                        </li>
                        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Cruise<span><i class="fa fa-angle-down"></i></span></a>
                            <ul class="dropdown-menu">
                            	<li><a href="cruise-homepage.html">Cruise Homepage</a></li>
                                <li><a href="cruise-listing-left-sidebar.html">List View Left Sidebar</a></li>
                                <li><a href="cruise-listing-right-sidebar.html">List View Right Sidebar</a></li>
                                <li><a href="cruise-grid-left-sidebar.html">Grid View Left Sidebar</a></li>
                                <li><a href="cruise-grid-right-sidebar.html">Grid View Right Sidebar</a></li>
                                <li><a href="cruise-detail-left-sidebar.html">Detail Left Sidebar</a></li>
                                <li><a href="cruise-detail-right-sidebar.html">Detail Right Sidebar</a></li>
                            </ul>			
                        </li>
                        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Cars<span><i class="fa fa-angle-down"></i></span></a>
                            <ul class="dropdown-menu">
                            	<li><a href="car-homepage.html">Car Homepage</a></li>
                                <li><a href="car-listing-left-sidebar.html">List View Left Sidebar</a></li>
                                <li><a href="car-listing-right-sidebar.html">List View Right Sidebar</a></li>
                                <li><a href="car-grid-left-sidebar.html">Grid View Left Sidebar</a></li>
                                <li><a href="car-grid-right-sidebar.html">Grid View Right Sidebar</a></li>
                                <li><a href="car-detail-left-sidebar.html">Detail Left Sidebar</a></li>
                                <li><a href="car-detail-right-sidebar.html">Detail Right Sidebar</a></li>
                            </ul>			
                        </li>
                        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Pages<span><i class="fa fa-angle-down"></i></span></a>
                            <ul class="dropdown-menu mega-dropdown-menu row">
                                <li>
                                    <div class="row">
                                        <div class="col-md-3">
                                            <ul class="list-unstyled">
                                                <li class="dropdown-header">Standard <span>Pages</span></li>
                                                <li><a href="about-us.html">About Us</a></li>
                                				<li><a href="contact-us.html">Contact Us</a></li>
                                                <li><a href="blog-listing-left-sidebar.html">Blog Listing Left Sidebar</a></li>
                                                <li><a href="blog-listing-right-sidebar.html">Blog Listing Right Sidebar</a></li>
                                                <li><a href="blog-detail-left-sidebar.html">Blog Detail Left Sidebar</a></li>
                                                <li><a href="blog-detail-right-sidebar.html">Blog Detail Right Sidebar</a></li>
                                            </ul>
                                        </div>
                                        
                                        <div class="col-md-3">
                                            <ul class="list-unstyled">	
                                                <li class="dropdown-header">User <span>Dashboard</span></li>
                                                <li><a href="dashboard.html">Dashboard</a></li>
                                                <li><a href="user-profile.html">User Profile</a></li>
                                                <li><a href="booking.html">Booking</a></li>
                                                <li><a href="wishlist.html">Wishlist</a></li>
                                                <li><a href="cards.html">Cards</a></li>
                                            </ul>
                                        </div>
                                        
                                        <div class="col-md-3">
                                            <ul class="list-unstyled">
                                                <li class="dropdown-header">Special <span>Pages</span></li>
                                                <li><a href="login.html">Login</a></li>
                                                <li><a href="registration.html">Registration</a></li>
                                                <li><a href="forgot-password.html">Forgot Password</a></li>
                                                <li><a href="error-page.html">404 Page</a></li>
                                                <li><a href="coming-soon.html">Coming Soon</a></li>   
                                            </ul>
                                        </div>
                                        
                                        <div class="col-md-3">
                                            <ul class="list-unstyled">
                                                <li class="dropdown-header">Extra <span>Pages</span></li>
                                                <li><a href="before-you-fly.html">Before Fly</a></li>
                                                <li><a href="travel-insurance.html">Travel Insurance</a></li>
                                                <li><a href="holidays.html">Holidays</a></li>
                                                <li><a href="thank-you.html">Thank You</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </li>
                            </ul>			
                        </li>
                		<li><a href="javascript:void(0)" class="search-button"><span><i class="fa fa-search"></i></span></a></li>
                    </ul>
                </div><!-- end navbar collapse -->
            </div><!-- end container -->
        </nav><!-- end navbar -->        
