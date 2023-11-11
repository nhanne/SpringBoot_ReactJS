import React from 'react'
import { useState, useEffect, createContext } from 'react'

const FilterContext = createContext()
function FilterProvider({ children }) {
    const [search, setSearch] = useState('');
    const [sort, setSort] = useState('Mặc định');
    const [category, setCategory] = useState('');
    const [products, setProducts] = useState([]);

    useEffect(() => {
        fetch(`/products?category=${category}&&sort=${sort}&&name=${search}`)
            .then(res => res.json())
            .then(response => {
                setProducts(response);
            });
    }, [category, sort, search])
    
    const value = {
        search, setSearch,
        sort, setSort,
        category, setCategory,
        products
    }

    return (
        <FilterContext.Provider value={value}>
            {children}
        </FilterContext.Provider>
    )
}
export { FilterContext, FilterProvider }