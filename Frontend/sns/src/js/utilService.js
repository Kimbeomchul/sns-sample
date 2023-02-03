const querystringToJSON = querystring => {
    if(!querystring) return null

    return querystring.split('&')
                      .map(v => v.split('='))
                      .reduce((acc, cur) => ({...acc, [cur[0]]:cur[1]}), {})
}

export const getQuerystringItem = (querystring, key) => {
    return querystringToJSON(querystring)?.[key]
}