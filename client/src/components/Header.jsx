import { useState, useEffect, cloneElement } from "react";
import React from "react";
import { HomeIcon, LanguageIcon } from "@heroicons/react/24/outline";
import {
  Typography,

} from "@material-tailwind/react";
// import iconImage from '../../assets/icon.jpg';
import iconImage from '../assets/icon.jpg';
import { path, USER_ROLE } from "../utils/constant";
import { useNavigate } from "react-router-dom";
const Header = ({ role }) => {
  const [openNav, setOpenNav] = useState(false);
  const navigate = useNavigate();
  useEffect(() => {
    window.addEventListener(
      "resize",
      () => window.innerWidth >= 960 && setOpenNav(false),
    );
  }, []);
  const backAdminpage = () => {
    navigate(path.HOMEPAGEADMIN);
  }
  if (role == 'main') {
    return (
      <nav class="bg-white  sticky top-0 z-50 shadow-md">
        <div class="mx-auto h-[70px]  px-2 sm:px-6 lg:px-8">
          <div class="relative flex h-16 items-center justify-between">
            <div class="flex flex-1 items-center justify-center sm:items-stretch sm:justify-start">
              <div class="flex flex-shrink-0 items-center">
              </div>
              <div class="flex flex-rol items-center  px-3 py-2">
                <img src={iconImage} alt="Logo" className="w-[75px]" />
                <Typography variant="small" className=" font-bold text-blue-500 text-[20px] font-sans">
                  BOOKING CARE
                </Typography>

              </div>
            </div>
            <div class="mb-4 mr-[70px] mt-2 flex flex-col gap-2 lg:mb-0 lg:mt-0 lg:flex-row lg:items-center lg:gap-14">
              <div class="hidden sm:ml-6 sm:block">
                <div class="flex space-x-[60px]">
                  <div class="text-[#636363] space-x-[50px] flex flex-rol rounded-md px-3 text-md font-semibold items-center">
                    <div>
                      Home
                    </div>
                    <div>
                      About Us
                    </div>
                    <div>
                      Service
                    </div>
                    <div>
                      Blog
                    </div>
                    <div>
                      Contact Us
                    </div>
                  </div>
                  <div class="">
                    <a
                      href="/login"
                      class="rounded-md bg-blue-700 px-5 py-2 text-md font-medium  text-white"
                      aria-current="page"
                    >
                      Log In
                    </a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </nav>
    )
  };
  if (role == 'user') {
    return (
      <nav class="bg-white shadow-md">
        <div class="mx-auto max-w-7xl px-2 sm:px-6 lg:px-8">
          <div class="relative flex h-16 items-center justify-between">
            <div class="flex flex-1 items-center justify-center sm:items-stretch sm:justify-start">
              <div class="flex flex-shrink-0 items-center">
              </div>
              <div class="flex flex-col space-x-4 px-3 py-2">
                <Typography variant="small" className="px-2 font-bold">
                  BOOKING CARE
                </Typography>

              </div>
            </div>
            <div class="mb-4 mt-2 flex flex-col gap-2 lg:mb-0 lg:mt-0 lg:flex-row lg:items-center lg:gap-14">
              <div class="hidden sm:ml-6 sm:block">
                <div class="flex space-x-4">
                  <div class="text-black-300 flex flex-col rounded-md px-3 text-sm font-semibold">
                    <div class="flex flex-row pl-4 pt-3">
                      {" "}
                      <LanguageIcon className="w-5 pr-1" /> Ngôn ngữ
                    </div>
                    <select class="text-black-300 flex flex-col rounded-md px-5 py-1 text-xs font-light">
                      <option>Tiếng Việt</option>
                      <option>Tiếng Anh</option>
                    </select>
                  </div>
                  <div class="pt-4">
                    <a
                      href="/login"
                      class="rounded-md bg-blue-700 px-3 py-2 text-sm font-medium text-white"
                      aria-current="page"
                    >
                      Đăng nhập
                    </a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </nav>
    )
  };
  if (role == 'admin') {
    return (
      <nav class="bg-white shadow-md sticky top-0 z-50">
        <div class="mx-auto h-[70px]  px-2 sm:px-6 lg:px-8">
          <div class="relative flex h-16 items-center justify-between">
            <div class="flex flex-1 items-center justify-center sm:items-stretch sm:justify-start">
              <div class="flex flex-shrink-0 items-center">
              </div>
              <div class="flex flex-rol items-center  px-3 py-2">
                <img src={iconImage} alt="Logo" className="w-[75px]" onClick={() => backAdminpage()}/>
                <Typography variant="small" className=" font-bold text-blue-500 text-[20px] font-sans">
                  BOOKING CARE
                </Typography>

              </div>
            </div>
            <div class="mb-4 mr-[70px] mt-2 flex flex-col gap-2 lg:mb-0 lg:mt-0 lg:flex-row lg:items-center lg:gap-14">
              <div class="hidden sm:ml-6 sm:block">
                <div class="flex space-x-[60px]">
                  {/* <div class="text-[#636363] space-x-[50px] flex flex-rol rounded-md px-3 text-md font-semibold items-center">
                    <div>
                      Home
                    </div>
                    <div>
                      About Us
                    </div>
                    <div>
                      Service
                    </div>
                    <div>
                      Blog
                    </div>
                    <div>
                      Contact Us
                    </div>
                  </div> */}
                  <div class="flex items-center space-x-4">
                    <p className="font-bold text-red-800 text-[20px]">Administrator</p>
                    <a
                      href="/"
                      class="rounded-md bg-red-600 px-4 py-2 text-md font-medium  text-white"
                      aria-current="page"
                    >
                      Log Out
                    </a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </nav>
    )
  };
};

export default Header;