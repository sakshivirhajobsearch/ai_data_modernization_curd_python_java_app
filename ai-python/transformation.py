# transformation.py

def transform_legacy_data(legacy_data):
    """
    Transforms legacy data into a modernized format.
    Supports both string-based and structured (dict) legacy data.
    """

    if isinstance(legacy_data, str):
        # Example: reverse the string and uppercase
        return legacy_data[::-1].upper()

    elif isinstance(legacy_data, dict):
        modernized = {}
        for key, value in legacy_data.items():
            # Transform keys: camelCase to snake_case (example)
            new_key = camel_to_snake_case(key)

            # Transform values: example logic
            if isinstance(value, str):
                new_value = value.strip().capitalize()
            elif isinstance(value, int):
                new_value = value + 100  # e.g., offset legacy numeric values
            else:
                new_value = value

            modernized[new_key] = new_value

        return modernized

    else:
        raise ValueError("Unsupported data format. Must be string or dict.")


def camel_to_snake_case(name):
    """Convert CamelCase or camelCase to snake_case."""
    import re
    s1 = re.sub('(.)([A-Z][a-z]+)', r'\1_\2', name)
    return re.sub('([a-z0-9])([A-Z])', r'\1_\2', s1).lower()
