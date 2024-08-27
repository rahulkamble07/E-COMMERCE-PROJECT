import KeyboardArrowLeftIcon from "@mui/icons-material/KeyboardArrowLeft";
import { Button } from "@mui/material";
import React from "react";
import AliceCarousel from "react-alice-carousel";
import "react-alice-carousel/lib/alice-carousel.css";

import HomeSectionCard from "../HomeSectionCard/HomeSectionCard";

const HomeSectionCarosel = ({data,sectionName}) => {
  const responsive = {
    0: { items: 1 },
    720: { items: 3 },
    1024: { items: 5.5 },
  };

  const items = data
    .slice(0, 10)
    .map((item) => <HomeSectionCard product={item} />);

  
  return (
    <div className="border ">
      <h2 className="text-2xl font-extrabold text-gray-800 py-5">{sectionName}</h2>
      <div className="relative p-5">
        <AliceCarousel
          items={items}
          responsive={responsive}
          disableDotsControls
          renderPrevButton={() => (
            
            <Button
              variant="contained"
              className="z-50"
              sx={{
                position: "absolute",
                top: "11rem",
                left: "-4rem",
                transform: "translateX(50%) rotate(90deg)",
                bgcolor: "white",
              }}
              aria-label="prev"
            >
              <KeyboardArrowLeftIcon
                sx={{ transform: "rotate(-90deg)", color: "black" }}
              />
            </Button> 
          )}
          renderNextButton={(isDisabled) => (
            <Button
              variant="contained"
              className="z-50"
              sx={{
                position: "absolute",
                top: "11rem",
                right: "0rem",
                transform: "translateX(50%) rotate(90deg)",
                bgcolor: "white",
              }}
              aria-label="next"
            >
              <KeyboardArrowLeftIcon
                sx={{ transform: "rotate(90deg)", color: "black" }}
              />
            </Button>
          )}
        />
      </div>
    </div>
  );
};

export default HomeSectionCarosel;
