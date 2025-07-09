import React, { useContext } from 'react';
import { StoreContext } from '../../context/StoreContext';
import Fooditem from '../FoodItem/Fooditem';

const FoodDisplay = ({category, searchText}) => {

  const {foodList} = useContext(StoreContext);
  console.log(foodList);
  
  const filteredFoods = foodList.filter(food => (
    (category === 'All' || food.category === category) && 
    food.name.toLowerCase().includes(searchText.toLowerCase())
  ));
  console.log(filteredFoods);
  
  return (
    <div className="container">
      <div className="row">
        {filteredFoods.length > 0 ? (
          filteredFoods.map((food, index) => (
            <Fooditem 
            key={food.id} 
            name= {food.name} 
            description= {food.description} 
            id= {food.id} 
            imageUrl={food.imageUrl}
            price= {food.price} 
            />
          ))
        ) : (
          <div className="text-center mt-4">
            <h4>No food Items found.</h4>
          </div>
        )}
      </div>
    </div>
  )
}

export default FoodDisplay;