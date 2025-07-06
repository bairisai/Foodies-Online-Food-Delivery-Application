import React from 'react';
import FoodDisplay from '../../components/FoodDisplay/FoodDisplay';
FoodDisplay
const Explore = () => {
  return (
    <>
    <div className="container">
      <div className="row justify-content-center">
        <div className="col-md-6">
          <form>
            <div className="input-group mb-3">
              <select className='form-select mt-2' style={{'maxWidth' : '150px'}}>
                <option value="biryani">Biryani</option>
                  <option value="burger">Burger</option>
                  <option value="cakes">Cakes</option>
                  <option value="icecream">Ice cream</option>
                  <option value="pizza">Pizza</option>
                  <option value="rolls">Rolls</option>
                  <option value="salad">Salad</option>
              </select>
              <input type="text" className='form-control mt-2' placeholder='Search your favourite dish..' />
              <button className='btn btn-primary mt-2' type='submit'>
                <i className='bi bi-search'></i>
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
    <FoodDisplay />
    </>
    
  )
}

export default Explore;