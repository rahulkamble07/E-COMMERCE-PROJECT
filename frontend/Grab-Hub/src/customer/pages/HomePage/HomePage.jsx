import React from "react";
import MainCarosel from "../../components/HomeCarosel/MainCarosel";
import HomeSectionCarosel from "../../components/HomeSectionCarosel/HomeSectionCarosel";
import { mens_kurta } from "../../../Data/mens_kurta";
import { mensShoesPage1 } from "../../Data/shoes";

const HomePage = () => {
  return (
    <div>
      <MainCarosel />

      <div className="space-y-10 py-20 flex flex-col justify-center px-5  lg:px-10">
        <HomeSectionCarosel data={mens_kurta} sectionName={"Men's Kurta"} />
        <HomeSectionCarosel data={mensShoesPage1} sectionName={"Men's Shoe"}/>
        <HomeSectionCarosel data={mens_kurta} sectionName={"Men's Shirt"} />
        <HomeSectionCarosel data={mens_kurta} sectionName={"Women's Saree"} />
        <HomeSectionCarosel data={mens_kurta} sectionName={"Women's Drees"} />
      </div>
    </div>
  );
};

export default HomePage;
