ring-headers-formatter
======================

A Ring's middleware that converts response's headers into Title-Case and make sure that keys and values are strings."

[![CircleCI](https://circleci.com/gh/druids/ring-headers-formatter.svg?style=svg)](https://circleci.com/gh/druids/ring-headers-formatter)
[![Dependencies Status](https://jarkeeper.com/druids/ring-headers-formatter/status.png)](https://jarkeeper.com/druids/ring-headers-formatter)
[![License](https://img.shields.io/badge/MIT-Clause-blue.svg)](https://opensource.org/licenses/MIT)


Leiningen/Boot
--------------

```clojure
[ring-headers-formatter "0.1.0"]
```


Documentation
-------------


Wrap your handlers into `wrap-response-headers`.

```clojure
(require '[ring-headers-formatter.core :refer [wrap-response-headers]]
         '[ring.util.response :refer [response]])

(defn handler [request]
  {:response {:foo "bar"}, :headers {:x-limit 100}})

(def app
  (wrap-response-headers handler))
```

And response's headers will be formatted like this:

```clojure
{:response {:foo "bar"}, :headers {"X-Limit" "100"}}
```

Please notice that lazy sequences in values aren't converted into strings, rather they passed as they are.


Contribution
------------

### Conventions

* Please follow coding style defined by [`.editorconfig`](http://editorconfig.org)
 and [The Clojure Style Guide](https://github.com/bbatsov/clojure-style-guide)
* Write [good commit messages](https://chris.beams.io/posts/git-commit/)
 and provide an issue ID in a commit message prefixed by `#`
