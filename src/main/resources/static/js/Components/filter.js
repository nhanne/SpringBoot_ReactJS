import React from 'react'
import { Link } from 'react-router-dom'

import { useContext } from 'react'
import { FilterContext } from '../storeContext.js'

import Select from './filter.select.js'
import Search from './filter.search.js'


function Filter() {
    const context = useContext(FilterContext)

    return (
        <div className="home-filter">
            <div className="home-filter__page">
                <span className="home-filter__page-logo">
                    Clothings Store
                </span>
            </div>
            <Select />
            <Search />
        </div>
    )
}

export default Filter