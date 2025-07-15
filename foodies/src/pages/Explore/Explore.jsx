import React, { useState } from "react";
import FoodDisplay from "../../components/FoodDisplay/FoodDisplay";

const Explore = () => {
  const [category, setCategory] = useState("All");
  const [searchText, setSearchText] = useState("");

  return (
    <>
      <div className="container">
        <div className="row justify-content-center">
          <div className="col-md-6">
            <form onSubmit={(e) => e.preventDefault()}>
              <div className="input-group mb-3">
                <select
                  className="form-select mt-2"
                  style={{ maxWidth: "150px" }}
                  onChange={(e) => setCategory(e.target.value)}
                >
                  <option value="All">All</option>
                  <option value="biryani">Biryani</option>
                  <option value="burger">Burger</option>
                  <option value="cakes">Cakes</option>
                  <option value="icecream">Ice cream</option>
                  <option value="pizza">Pizza</option>
                  <option value="rolls">Rolls</option>
                  <option value="salad">Salad</option>
                </select>
                <input
                  type="text"
                  className="form-control mt-2"
                  placeholder="Search your favourite dish.."
                  onChange={(e) => setSearchText(e.target.value)}
                  value={searchText}
                />
                <button className="btn btn-primary mt-2" type="submit">
                  <i className="bi bi-search"></i>
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
      <FoodDisplay category={category} searchText={searchText} />
    </>
  );
};

export default Explore;
