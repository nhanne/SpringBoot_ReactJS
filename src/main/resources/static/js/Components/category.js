import React from 'react'
import { Link } from 'react-router-dom'
import { useState, useEffect, useContext } from 'react'
import { FilterContext } from '../storeContext.js'

function Categories() {
    const context = useContext(FilterContext)
    const [categories, setCategories] = useState([]);
   
    useEffect(() => {
        fetch(`/categories`)
            .then(res => res.json())
            .then(response => {
                setCategories(response);
            })
    }, [])

    return (
        <React.Fragment>
            <div className="grid__column-2">
                <nav className="category">
                    <ul className='category-list' id='mySidebar'>
                        <li key={0} className='category-item'>
                            <Link to="/store"
                                className='category-item__link'
                                onClick={() => context.setCategory('')}
                            >
                                New Stuff
                            </Link>
                        </li>
                        {categories.map(category => (
                            <li key={category.Id} className='category-item'>
                                <Link to="/store"
                                    className='category-item__link'
                                    onClick={() => context.setCategory(category.Id)}
                                >
                                    {category.Name}
                                </Link>
                            </li>
                        ))}
                    </ul>
                </nav>
            </div>
            <button type="button" className="openbtn" onClick={() => openNav()}>☰ Danh mục</button>
        </React.Fragment>
    )
}
export default React.memo(Categories)